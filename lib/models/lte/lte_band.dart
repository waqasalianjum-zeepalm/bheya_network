class BandLTE {
  int? downlinkEarfcn;
  int? channelNumber;
  String? name;
  int? number;

  BandLTE({this.downlinkEarfcn, this.channelNumber, this.name, this.number});

  BandLTE.fromJson(Map<String, dynamic> json) {
    downlinkEarfcn = json['downlinkEarfcn'];
    channelNumber = json['channelNumber'];
    name = json['name'];
    number = json['number'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['downlinkEarfcn'] = downlinkEarfcn;
    data['channelNumber'] = channelNumber;
    data['name'] = name;
    data['number'] = number;
    return data;
  }
}
