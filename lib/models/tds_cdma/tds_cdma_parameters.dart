import '../common/network.dart';
import '../tds_cdma/tds_cdma_signal.dart';
import '../wcdma/wcdma_band.dart';

class Tdscdma {
  BandWCDMA? bandTDSCDMA;
  SignalTDSCDMA? signalTDSCDMA;
  String? connectionStatus;
  Network? network;
  String? type;

  Tdscdma(
      {this.bandTDSCDMA,
      this.signalTDSCDMA,
      this.connectionStatus,
      this.network,
      this.type});

  Tdscdma.fromJson(Map<String, dynamic> json) {
    bandTDSCDMA = json['bandTDSCDMA'] != null
        ? BandWCDMA.fromJson(json['bandTDSCDMA'])
        : null;
    signalTDSCDMA = json['signalTDSCDMA'] != null
        ? SignalTDSCDMA.fromJson(json['signalTDSCDMA'])
        : null;
    connectionStatus = json['connectionStatus'];
    network =
        json['network'] != null ? Network.fromJson(json['network']) : null;
    type = json['type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    if (bandTDSCDMA != null) {
      data['bandTDSCDMA'] = bandTDSCDMA!.toJson();
    }
    if (signalTDSCDMA != null) {
      data['signalTDSCDMA'] = signalTDSCDMA!.toJson();
    }
    data['connectionStatus'] = connectionStatus;
    if (network != null) {
      data['network'] = network!.toJson();
    }
    data['type'] = type;
    return data;
  }
}
