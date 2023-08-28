import 'package:flutter/services.dart';

class BheyaNetwork {
  static const MethodChannel _channel = MethodChannel('cell_info');

  static Future<String?> get getCellInfo async {
    final String? version = await _channel.invokeMethod('cell_info');
    return version;
  }

  static const MethodChannel _simInfo = MethodChannel('sim_info');

  static Future<String?> get getSIMInfo async {
    final String? version = await _simInfo.invokeMethod('sim_info');
    return version;
  }
}
