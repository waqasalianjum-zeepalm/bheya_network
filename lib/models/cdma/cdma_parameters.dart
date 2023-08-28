import 'package:bheya_network/models/common/network.dart';

import 'cdma_band.dart';
import 'cdma_signal.dart';

class Cdma {
  Band? band;
  int? bid;
  SignalCDMA? signalCDMA;
  String? connectionStatus;
  Network? network;
  String? type;

  Cdma(
      {this.band,
      this.bid,
      this.signalCDMA,
      this.connectionStatus,
      this.network,
      this.type});

  Cdma.fromJson(Map<String, dynamic> json) {
    band = json['band'] != null ? Band.fromJson(json['band']) : null;
    bid = json['bid'];
    signalCDMA = json['signalCDMA'] != null
        ? SignalCDMA.fromJson(json['signalCDMA'])
        : null;
    connectionStatus = json['connectionStatus'];
    network =
        json['network'] != null ? Network.fromJson(json['network']) : null;
    type = json['type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    if (band != null) {
      data['band'] = band!.toJson();
    }
    data['bid'] = bid;
    if (signalCDMA != null) {
      data['signalCDMA'] = signalCDMA!.toJson();
    }
    data['connectionStatus'] = connectionStatus;
    if (network != null) {
      data['network'] = network!.toJson();
    }
    data['type'] = type;
    return data;
  }
}
