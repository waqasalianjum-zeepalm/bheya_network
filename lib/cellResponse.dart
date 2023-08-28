// ignore_for_file: file_names

import 'models/common/cell_type.dart';

class CellsResponse {
  List<CellType>? neighboringCellList;
  List<CellType>? primaryCellList;

  CellsResponse({this.neighboringCellList, this.primaryCellList});

  CellsResponse.fromJson(Map<String, dynamic> json) {
    if (json['neighboringCellList'] != null) {
      neighboringCellList = [];
      json['neighboringCellList'].forEach((v) {
        neighboringCellList!.add(CellType.fromJson(v));
      });
    }
    if (json['primaryCellList'] != null) {
      primaryCellList = [];
      json['primaryCellList'].forEach((v) {
        primaryCellList!.add(CellType.fromJson(v));
      });
    }
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    if (neighboringCellList != null) {
      data['neighboringCellList'] =
          neighboringCellList!.map((v) => v.toJson()).toList();
    }
    if (primaryCellList != null) {
      data['primaryCellList'] =
          primaryCellList!.map((v) => v.toJson()).toList();
    }
    return data;
  }
}
