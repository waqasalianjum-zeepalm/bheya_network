class Network {
  String? iso;
  String? mcc;
  String? mnc;

  Network({this.iso, this.mcc, this.mnc});

  Network.fromJson(Map<String, dynamic> json) {
    iso = json['iso'];
    mcc = json['mcc'];
    mnc = json['mnc'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['iso'] = iso;
    data['mcc'] = mcc;
    data['mnc'] = mnc;
    return data;
  }
}
