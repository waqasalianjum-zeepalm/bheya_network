class SignalTDSCDMA {
  int? bitErrorRate;
  int? rscp;
  int? rscpAsu;
  int? rssi;
  int? rssiAsu;
  int? dbm;

  SignalTDSCDMA(
      {this.bitErrorRate,
      this.rscp,
      this.rscpAsu,
      this.rssi,
      this.rssiAsu,
      this.dbm});

  SignalTDSCDMA.fromJson(Map<String, dynamic> json) {
    bitErrorRate = json['bitErrorRate'];
    rscp = json['rscp'];
    rscpAsu = json['rscpAsu'];
    rssi = json['rssi'];
    rssiAsu = json['rssiAsu'];
    dbm = json['dbm'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['bitErrorRate'] = bitErrorRate;
    data['rscp'] = rscp;
    data['rscpAsu'] = rscpAsu;
    data['rssi'] = rssi;
    data['rssiAsu'] = rssiAsu;
    data['dbm'] = dbm;
    return data;
  }
}
