class SignalLTE {
  int? cqi;
  double? rsrp;
  int? rsrpAsu;
  double? rsrq;
  int? rssi;
  int? rssiAsu;
  double? snr;
  int? timingAdvance;
  int? dbm;

  SignalLTE(
      {this.cqi,
      this.rsrp,
      this.rsrpAsu,
      this.rsrq,
      this.rssi,
      this.rssiAsu,
      this.snr,
      this.timingAdvance,
      this.dbm});

  SignalLTE.fromJson(Map<String, dynamic> json) {
    cqi = json['cqi'];
    rsrp = json['rsrp'];
    rsrpAsu = json['rsrpAsu'];
    rsrq = json['rsrq'];
    rssi = json['rssi'];
    rssiAsu = json['rssiAsu'];
    snr = json['snr'];
    timingAdvance = json['timingAdvance'];
    dbm = json['dbm'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['cqi'] = cqi;
    data['rsrp'] = rsrp;
    data['rsrpAsu'] = rsrpAsu;
    data['rsrq'] = rsrq;
    data['rssi'] = rssi;
    data['rssiAsu'] = rssiAsu;
    data['snr'] = snr;
    data['timingAdvance'] = timingAdvance;
    data['dbm'] = dbm;
    return data;
  }
}
