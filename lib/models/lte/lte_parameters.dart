import '../common/network.dart';

import 'lte_band.dart';
import 'lte_signal.dart';

class Lte {
  BandLTE? bandLTE;
  int? bandwidth;
  int? cid;
  int? eci;
  int? enb;
  int? pci;
  String? ecgi;
  SignalLTE? signalLTE;
  int? tac;
  String? connectionStatus;
  Network? network;
  int? subscriptionId;
  String? type;

  Lte(
      {this.bandLTE,
      this.bandwidth,
      this.cid,
      this.eci,
      this.enb,
      this.pci,
      this.signalLTE,
      this.tac,
      this.ecgi,
      this.connectionStatus,
      this.network,
      this.subscriptionId,
      this.type});

  Lte.fromJson(Map<String, dynamic> json) {
    bandLTE =
        json['bandLTE'] != null ? BandLTE.fromJson(json['bandLTE']) : null;
    bandwidth = json['bandwidth'];
    cid = json['cid'];
    eci = json['eci'];
    enb = json['enb'];
    ecgi = json['ecgi'];
    pci = json['pci'];
    signalLTE = json['signalLTE'] != null
        ? SignalLTE.fromJson(json['signalLTE'])
        : null;
    tac = json['tac'];
    connectionStatus = json['connectionStatus'];
    network =
        json['network'] != null ? Network.fromJson(json['network']) : null;
    subscriptionId = json['subscriptionId'];
    type = json['type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    if (bandLTE != null) {
      data['bandLTE'] = bandLTE!.toJson();
    }
    data['bandwidth'] = bandwidth;
    data['cid'] = cid;
    data['eci'] = eci;
    data['enb'] = enb;
    data['pci'] = pci;
    data['ecgi'] = ecgi;
    if (signalLTE != null) {
      data['signalLTE'] = signalLTE!.toJson();
    }
    data['tac'] = tac;
    data['connectionStatus'] = connectionStatus;
    if (network != null) {
      data['network'] = network!.toJson();
    }
    data['subscriptionId'] = subscriptionId;
    data['type'] = type;
    return data;
  }
}
