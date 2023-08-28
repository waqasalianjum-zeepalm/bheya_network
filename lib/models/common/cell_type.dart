import '../cdma/cdma_parameters.dart';
import '../gsm/gms_parameters.dart';
import '../lte/lte_parameters.dart';
import '../nr/nr_parameters.dart';
import '../tds_cdma/tds_cdma_parameters.dart';
import '../wcdma/wcdma_parameters.dart';

class CellType {
  String? type;
  Wcdma? wcdma;
  Nr? nr;
  Lte? lte;
  Gsm? gsm;
  Tdscdma? tdscdma;
  Cdma? cdma;

  CellType(
      {this.type,
      this.wcdma,
      this.nr,
      this.lte,
      this.gsm,
      this.tdscdma,
      this.cdma});

  CellType.fromJson(Map<String, dynamic> json) {
    type = json['type'];
    wcdma = json['wcdma'] != null ? Wcdma.fromJson(json['wcdma']) : null;
    nr = json['nr'] != null ? Nr.fromJson(json['nr']) : null;
    lte = json['lte'] != null ? Lte.fromJson(json['lte']) : null;
    gsm = json['gsm'] != null ? Gsm.fromJson(json['gsm']) : null;
    tdscdma =
        json['tdscdma'] != null ? Tdscdma.fromJson(json['tdscdma']) : null;
    cdma = json['cdma'] != null ? Cdma.fromJson(json['cdma']) : null;
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['type'] = type;
    if (wcdma != null) {
      data['wcdma'] = wcdma!.toJson();
    }
    if (nr != null) {
      data['nr'] = nr!.toJson();
    }
    if (lte != null) {
      data['lte'] = lte!.toJson();
    }
    if (gsm != null) {
      data['gsm'] = gsm!.toJson();
    }
    if (tdscdma != null) {
      data['tdscdma'] = tdscdma!.toJson();
    }
    if (cdma != null) {
      data['cdma'] = cdma!.toJson();
    }
    return data;
  }
}
