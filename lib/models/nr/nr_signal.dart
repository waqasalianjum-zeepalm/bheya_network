class SignalNR {
  int? csiRsrp;
  int? csiRsrpAsu;
  int? csiRsrq;
  int? csiSinr;
  int? ssRsrp;
  int? ssRsrpAsu;
  int? ssRsrq;
  int? ssSinr;
  int? dbm;

  SignalNR(
      {this.csiRsrp,
      this.csiRsrpAsu,
      this.csiRsrq,
      this.csiSinr,
      this.ssRsrp,
      this.ssRsrpAsu,
      this.ssRsrq,
      this.ssSinr,
      this.dbm});

  SignalNR.fromJson(Map<String, dynamic> json) {
    csiRsrp = json['csiRsrp'];
    csiRsrpAsu = json['csiRsrpAsu'];
    csiRsrq = json['csiRsrq'];
    csiSinr = json['csiSinr'];
    ssRsrp = json['ssRsrp'];
    ssRsrpAsu = json['ssRsrpAsu'];
    ssRsrq = json['ssRsrq'];
    ssSinr = json['ssSinr'];
    dbm = json['dbm'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['csiRsrp'] = csiRsrp;
    data['csiRsrpAsu'] = csiRsrpAsu;
    data['csiRsrq'] = csiRsrq;
    data['csiSinr'] = csiSinr;
    data['ssRsrp'] = ssRsrp;
    data['ssRsrpAsu'] = ssRsrpAsu;
    data['ssRsrq'] = ssRsrq;
    data['ssSinr'] = ssSinr;
    data['dbm'] = dbm;
    return data;
  }
}
