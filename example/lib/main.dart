import 'dart:convert';

import 'package:bheya_network/cellResponse.dart';
import 'package:bheya_network/models/common/cell_type.dart';
import 'package:flutter/material.dart';
import 'package:bheya_network/bheya_network.dart';
import 'package:flutter/services.dart';
import 'package:permission_handler/permission_handler.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  CellsResponse? _cellsResponse;

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

  String currentDBM = "";

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    await providerCheckPermission();
    CellsResponse? cellsResponse;
    // Platform messages may fail, so we use a try/catch PlatformException.
    try {
      String platformVersion = (await BheyaNetwork.getCellInfo) ?? "";
      final body = json.decode(platformVersion);

      cellsResponse = CellsResponse.fromJson(body);

      CellType currentCellInFirstChip = cellsResponse.primaryCellList![0];
      if (currentCellInFirstChip.type == "LTE") {
        currentDBM = "LTE dbm = ${currentCellInFirstChip.lte!.signalLTE!.dbm}";
      } else if (currentCellInFirstChip.type == "NR") {
        currentDBM = "NR dbm = ${currentCellInFirstChip.nr!.signalNR!.dbm}";
      } else if (currentCellInFirstChip.type == "WCDMA") {
        currentDBM =
            "WCDMA dbm = ${currentCellInFirstChip.wcdma!.signalWCDMA!.dbm}";
      }
      // String simInfo = (await BheyaNetwork.getSIMInfo) ?? "";
      // final simJson = json.decode(simInfo);
    } on PlatformException {
      _cellsResponse = null;
    }

    if (!mounted) return;

    setState(() {
      _cellsResponse = cellsResponse;
    });
  }

  providerCheckPermission() async {
    await [
      Permission.location,
      Permission.storage,
      Permission.phone,
      Permission.locationWhenInUse,
    ].request();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: _cellsResponse != null
            ? Center(
                child: Text(
                    'david = $currentDBM\n primary = ${_cellsResponse!.primaryCellList!.length.toString()} \n neighbor = ${_cellsResponse!.neighboringCellList!.length}'),
              )
            : null,
      ),
    );
  }
}
