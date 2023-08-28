import '../common/network.dart';

import 'nr_band.dart';
import 'nr_signal.dart';

class Nr {
  BandNR? bandNR;
  int? nci;
  int? pci;
  SignalNR? signalNR;
  int? tac;
  String? connectionStatus;
  Network? network;
  String? type;

  Nr(
      {this.bandNR,
      this.nci,
      this.pci,
      this.signalNR,
      this.tac,
      this.connectionStatus,
      this.network,
      this.type});

  Nr.fromJson(Map<String, dynamic> json) {
    bandNR = json['bandNR'] != null ? BandNR.fromJson(json['bandNR']) : null;
    nci = json['nci'];
    pci = json['pci'];
    signalNR =
        json['signalNR'] != null ? SignalNR.fromJson(json['signalNR']) : null;
    tac = json['tac'];
    connectionStatus = json['connectionStatus'];
    network =
        json['network'] != null ? Network.fromJson(json['network']) : null;
    type = json['type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    if (bandNR != null) {
      data['bandNR'] = bandNR!.toJson();
    }
    data['nci'] = nci;
    data['pci'] = pci;
    if (signalNR != null) {
      data['signalNR'] = signalNR!.toJson();
    }
    data['tac'] = tac;
    data['connectionStatus'] = connectionStatus;
    if (network != null) {
      data['network'] = network!.toJson();
    }
    data['type'] = type;
    return data;
  }
}
