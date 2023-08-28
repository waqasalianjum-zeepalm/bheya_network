class SignalWCDMA {
  int? bitErrorRate;
  int? ecio;
  int? ecno;
  int? rscp;
  int? rscpAsu;
  int? rssi;
  int? rssiAsu;
  int? dbm;

  SignalWCDMA(
      {this.bitErrorRate,
      this.ecio,
      this.ecno,
      this.rscp,
      this.rscpAsu,
      this.rssi,
      this.rssiAsu,
      this.dbm});

  SignalWCDMA.fromJson(Map<String, dynamic> json) {
    bitErrorRate = json['bitErrorRate'];
    ecio = json['ecio'];
    ecno = json['ecno'];
    rscp = json['rscp'];
    rscpAsu = json['rscpAsu'];
    rssi = json['rssi'];
    rssiAsu = json['rssiAsu'];
    dbm = json['dbm'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['bitErrorRate'] = bitErrorRate;
    data['ecio'] = ecio;
    data['ecno'] = ecno;
    data['rscp'] = rscp;
    data['rscpAsu'] = rscpAsu;
    data['rssi'] = rssi;
    data['rssiAsu'] = rssiAsu;
    data['dbm'] = dbm;
    return data;
  }
}
