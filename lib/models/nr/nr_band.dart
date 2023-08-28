class BandNR {
  int? downlinkArfcn;
  int? downlinkFrequency;
  int? channelNumber;
  String? name;
  int? number;

  BandNR(
      {this.downlinkArfcn,
      this.downlinkFrequency,
      this.channelNumber,
      this.name,
      this.number});

  BandNR.fromJson(Map<String, dynamic> json) {
    downlinkArfcn = json['downlinkArfcn'];
    downlinkFrequency = json['downlinkFrequency'];
    channelNumber = json['channelNumber'];
    name = json['name'];
    number = json['number'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['downlinkArfcn'] = downlinkArfcn;
    data['downlinkFrequency'] = downlinkFrequency;
    data['channelNumber'] = channelNumber;
    data['name'] = name;
    data['number'] = number;
    return data;
  }
}
