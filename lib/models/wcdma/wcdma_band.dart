class BandWCDMA {
  int? downlinkUarfcn;
  int? channelNumber;
  String? name;
  int? number;

  BandWCDMA({this.downlinkUarfcn, this.channelNumber, this.name, this.number});

  BandWCDMA.fromJson(Map<String, dynamic> json) {
    downlinkUarfcn = json['downlinkUarfcn'];
    channelNumber = json['channelNumber'];
    name = json['name'];
    number = json['number'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['downlinkUarfcn'] = downlinkUarfcn;
    data['channelNumber'] = channelNumber;
    data['name'] = name;
    data['number'] = number;
    return data;
  }
}
