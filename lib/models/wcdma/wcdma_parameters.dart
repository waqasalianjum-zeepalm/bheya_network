import '../common/network.dart';
import '../wcdma/wcdma_band.dart';
import '../wcdma/wcdma_signal.dart';

class Wcdma {
  BandWCDMA? bandWCDMA;
  SignalWCDMA? signalWCDMA;
  String? connectionStatus;
  Network? network;
  String? type;

  Wcdma(
      {this.bandWCDMA,
      this.signalWCDMA,
      this.connectionStatus,
      this.network,
      this.type});

  Wcdma.fromJson(Map<String, dynamic> json) {
    bandWCDMA = json['bandWCDMA'] != null
        ? BandWCDMA.fromJson(json['bandWCDMA'])
        : null;
    signalWCDMA = json['signalWCDMA'] != null
        ? SignalWCDMA.fromJson(json['signalWCDMA'])
        : null;
    connectionStatus = json['connectionStatus'];
    network =
        json['network'] != null ? Network.fromJson(json['network']) : null;
    type = json['type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    if (bandWCDMA != null) {
      data['bandWCDMA'] = bandWCDMA!.toJson();
    }
    if (signalWCDMA != null) {
      data['signalWCDMA'] = signalWCDMA!.toJson();
    }
    data['connectionStatus'] = connectionStatus;
    if (network != null) {
      data['network'] = network!.toJson();
    }
    data['type'] = type;
    return data;
  }
}
