// ignore_for_file: unnecessary_new

class SignalCDMA {
  int? cdmaEcio;
  int? cdmaRssi;
  int? evdoEcio;
  int? evdoRssi;
  int? evdoSnr;
  int? dbm;

  SignalCDMA(
      {this.cdmaEcio,
        this.cdmaRssi,
        this.evdoEcio,
        this.evdoRssi,
        this.evdoSnr,
        this.dbm});

  SignalCDMA.fromJson(Map<String, dynamic> json) {
    cdmaEcio = json['cdmaEcio'];
    cdmaRssi = json['cdmaRssi'];
    evdoEcio = json['evdoEcio'];
    evdoRssi = json['evdoRssi'];
    evdoSnr = json['evdoSnr'];
    dbm = json['dbm'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['cdmaEcio'] = cdmaEcio;
    data['cdmaRssi'] = cdmaRssi;
    data['evdoEcio'] = evdoEcio;
    data['evdoRssi'] = evdoRssi;
    data['evdoSnr'] = evdoSnr;
    data['dbm'] = dbm;
    return data;
  }
}