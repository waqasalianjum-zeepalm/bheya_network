import '../common/network.dart';
import 'gsm_band.dart';
import 'gsm_signal.dart';

class Gsm {
  BandGSM? bandGSM;
  SignalGSM? signalGSM;
  String? connectionStatus;
  Network? network;
  String? type;

  Gsm(
      {this.bandGSM,
      this.signalGSM,
      this.connectionStatus,
      this.network,
      this.type});

  Gsm.fromJson(Map<String, dynamic> json) {
    bandGSM =
        json['bandGSM'] != null ? BandGSM.fromJson(json['bandGSM']) : null;
    signalGSM = json['signalGSM'] != null
        ? SignalGSM.fromJson(json['signalGSM'])
        : null;
    connectionStatus = json['connectionStatus'];
    network =
        json['network'] != null ? Network.fromJson(json['network']) : null;
    type = json['type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    if (bandGSM != null) {
      data['bandGSM'] = bandGSM!.toJson();
    }
    if (signalGSM != null) {
      data['signalGSM'] = signalGSM!.toJson();
    }
    data['connectionStatus'] = connectionStatus;
    if (network != null) {
      data['network'] = network!.toJson();
    }
    data['type'] = type;
    return data;
  }
}
