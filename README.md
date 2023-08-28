# BHEYA_NETWORK
BHEYA_NETWORK
This plugin is an improvement of [nr_cellinfo](https://pub.dev/packages/nr_cellinfo) 

Cell Info Plugin
    
Lightweight Android library that is build over [Telephony SDK](https://developer.android.com/reference/android/telephony/package-summary). NetMonster core is extracted from [NetMonster](https://play.google.com/store/apps/details?id=cz.mroczis.netmonster) application and backports several Telephony features to older Android devices.  
  
Why use NetMonster Core instead of legacy API?  
 - Validation - library validates data from RIL and corrects them if possible 
 - Richer information - additional functions for cell identity and cell signal that will make your code more understandable  
 - Backport - several non-accessible signal or identity fields are now accessible without boilerplate code  
 - Tested - tested on real devices, 50 000+ active users  

### New functions
Here's small comparison for each of voice / data network you can meet.

#### GSM
|function    |Min SDK Android|Min SDK NetMonster Core |
|------------|---------------|------------------------|
|CGI         |-              |I (14)                  |
|NCC         |-              |N (24)                  |
|BCC         |-              |N (24)                  |
|Band        |-              |N (24)                  |
|TA          |O (26)         |N (24)                  |

#### WCDMA  
|function    |Min SDK Android|Min SDK NetMonster Core |  
|------------|---------------|------------------------|
|CGI         |-              |I (14)                  |
|CID (16b)   |-              |I (14)                  |  
|RNC         |-              |I (14)                  |
|Ec/Io       |-              |M (23)                  |  
|Band        |-              |N (24)                  |  
|BER         |-              |Q (29)                  |  
|Ec/No       |-              |Q (29)                  |  
|RSCP        |-              |Q (29)                  |

#### LTE
|function    |Min SDK Android|Min SDK NetMonster Core |
|------------|---------------|------------------------|
|eCGI        |-              |I (14)                  |
|CID (8b)    |-              |I (14)                  |
|eNb         |-              |I (14)                  | 
|RSSI        |Q (29)         |I (14)                  |
|RSRP        |O (26)         |I (14)                  |
|CQI         |O (26)         |I (14)                  |
|SNR         |O (26)         |I (14)                  |
|TA          |O (26)         |I (14)                  |
|Band        |-              |N (24)                  |  


### Usage

There are basically two ways you can use this library - as a validation library that will sanitize
data from AOSP cause lots of manufacturers modify source code and do not follow public documentation.
In that case you'll only need `ITelephonyManagerCompat` to retrieve AOSP-like models that are properly
validated.

The second option is to use advantages of additional postprocessing of NetMonster Core. As a result
you'll get more data but correctness is not 100 % guaranteed. 

#### Without additional postprocessing

NetMonster Core focuses on mapping of two AOSP's ways to fetch current cell information:
 - [TelephonyManager.getAllCellInfo()](https://developer.android.com/reference/android/telephony/TelephonyManager#getAllCellInfo())
 - [TelephonyManager.getCellLocation()](https://developer.android.com/reference/android/telephony/TelephonyManager.html#getCellLocation()) (deprecated in AOSP)
 - TelephonyManager.getNeighbouringCellInfo() (removed from AOSP)

Note that some of those methods are deprecated or even removed from AOSP - for more info see documentation of each method.


#### Postprocessing

In this case you'll need to interact with `INetMonster` class. Here's list of problems 
that this library solves.

##### Merging data from multiple sources
Issue:
 - Android offers multiple ways how to get cell information.
 - Not all devices support one unified way how to access all the data.

Solution:
 - NetMonster Core grabs data from sources you specify, validates and merges them.



##### Detection of LTE-A & HSPA+42
Issue:
 - AOSP cannot detect HSPA+42, only HSPA+.
 - AOSP does not offer a way to distinguish whether current network is using carrier aggregation or not.

Solution:
 - NetMonster Core attempts to guess HSPA+ 42 availability.
 - LTE-CA presence can be guessed based on cell info or detected using hidden APIs.

Using `getNetworkType(vararg detectors: INetworkDetector)` you can specify which `INetworkDetector` to use
when detecting current network type.



##### Other features
 - Detection of serving cells in 'emergency calls only' mode.
 - PLMN addition to non-serving cells in GSM, WCDMA, LTE, TD-SCDMA and NR networks.

License
-------

    Copyright 2019 Eslam Faisal
    
    Licensed under the Apache License, Version 2.0 (the "License");

    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    

    http://www.apache.org/licenses/LICENSE-2.0

    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and

 ### Preview 
| ![](https://github.com/saliemmanuel/bheya_network/blob/master/Screenshot/a.png)| ![](https://github.com/saliemmanuel/bheya_network/blob/master/Screenshot/b.png) |
|---------|
| ![](https://github.com/saliemmanuel/bheya_network/blob/master/Screenshot/c.png)| ![](https://github.com/saliemmanuel/bheya_network/blob/master/Screenshot/d.png) |
|---------|
| ![](https://github.com/saliemmanuel/bheya_network/blob/master/Screenshot/e.png)| ![](https://github.com/saliemmanuel/bheya_network/blob/master/Screenshot/f.png) |
|---------|
| ![](https://github.com/saliemmanuel/bheya_network/blob/master/Screenshot/g.png)| ![](https://github.com/saliemmanuel/bheya_network/blob/master/Screenshot/h.png) |
|---------|
| ![](https://github.com/saliemmanuel/bheya_network/blob/master/Screenshot/i.png)| ![](https://github.com/saliemmanuel/bheya_network/blob/master/Screenshot/j.png) |
|---------|



## Code struct 

|-- android
|   |-- build.gradle  
|   |-- settings.gradle  
|   '-- src
|       |-- main
|       |   |-- AndroidManifest.xml  
|       |   '-- kotlin
|       |       '-- com
|       |           '-- example
|       |               '-- bheya_network
|       |                   |-- BheyaNetworkPlugin.kt  
|       |                   |-- NetMonster.kt 
|       |                   |-- core
|       |                   |   |-- INetMonster.kt  
|       |                   |   |-- NetMonster.kt 
|       |                   |   |-- callback
|       |                   |   |   '-- AllCellInfo.kt  
|       |                   |   |-- db
|       |                   |   |   |-- BandTableGsm.kt  
|       |                   |   |   |-- BandTableLte.kt  
|       |                   |   |   |-- BandTableNr.kt  
|       |                   |   |   |-- BandTableTdscdma.kt  
|       |                   |   |   |-- BandTableWcdma.kt  
|       |                   |   |   |-- MccIsoTable.kt 
|       |                   |   |   |-- NetworkTypeTable.kt  
|       |                   |   |   '-- model
|       |                   |   |       |-- BandEntity.kt  
|       |                   |   |       |-- Network.kt  
|       |                   |   |       '-- NetworkType.kt  
|       |                   |   |-- factory
|       |                   |   |   '-- NetMonsterFactory.kt  
|       |                   |   |-- feature
|       |                   |   |   |-- config
|       |                   |   |   |   |-- CellLocationSource.kt  
|       |                   |   |   |   |-- DisplayInfoSource.kt  
|       |                   |   |   |   |-- PhysicalChannelConfigSource.kt  
|       |                   |   |   |   |-- ServiceStateSource.kt  
|       |                   |   |   |   |-- SignalStrengthsSource.kt  
|       |                   |   |   |   '-- TelephonyManagerListeners.kt  
|       |                   |   |   |-- detect
|       |                   |   |   |   |-- DetectorAosp.kt  
|       |                   |   |   |   |-- DetectorHspaDc.kt  
|       |                   |   |   |   |-- DetectorLteAdvancedCellInfo.kt  
|       |                   |   |   |   |-- DetectorLteAdvancedNrDisplayInfo.kt  
|       |                   |   |   |   |-- DetectorLteAdvancedNrServiceState.kt  
|       |                   |   |   |   |-- DetectorLteAdvancedPhysicalChannel.kt  
|       |                   |   |   |   '-- INetworkDetector.kt  
|       |                   |   |   |-- merge
|       |                   |   |   |   |-- CellMerger.kt  
|       |                   |   |   |   |-- CellMergerNotPrimary.kt  
|       |                   |   |   |   |-- CellMergerPrimary.kt 
|       |                   |   |   |   |-- CellSignalMerger.kt  
|       |                   |   |   |   |-- CellSource.kt  
|       |                   |   |   |   '-- ICellMerger.kt  
|       |                   |   |   '-- postprocess
|       |                   |   |       |-- CdmaPlmnPostprocessor.kt  
|       |                   |   |       |-- ICellPostprocessor.kt  
|       |                   |   |       |-- InvalidCellsPostprocessor.kt  
|       |                   |   |       |-- MocnNetworkPostprocessor.kt  
|       |                   |   |       |-- PhysicalChannelPostprocessor.kt (11 KB)
|       |                   |   |       |-- PlmnPostprocessor.kt 
|       |                   |   |       |-- PrimaryCellPostprocessor.kt  
|       |                   |   |       |-- SignalStrengthPostprocessor.kt  
|       |                   |   |       '-- SubDuplicitiesPostprocessor.kt  
|       |                   |   |-- model
|       |                   |   |   |-- DisplayInfo.kt  
|       |                   |   |   |-- Network.kt  
|       |                   |   |   |-- SubscribedNetwork.kt  
|       |                   |   |   |-- annotation
|       |                   |   |   |   |-- DoubleRange.kt  
|       |                   |   |   |   |-- Experimental.kt  
|       |                   |   |   |   |-- SinceSdk.kt  
|       |                   |   |   |   '-- TillSdk.kt  
|       |                   |   |   |-- band
|       |                   |   |   |   |-- BandGsm.kt  
|       |                   |   |   |   |-- BandLte.kt  
|       |                   |   |   |   |-- BandNr.kt  
|       |                   |   |   |   |-- BandTdscdma.kt  
|       |                   |   |   |   |-- BandWcdma.kt  
|       |                   |   |   |   '-- IBand.kt  
|       |                   |   |   |-- cell
|       |                   |   |   |   |-- CellCdma.kt  
|       |                   |   |   |   |-- CellGsm.kt  
|       |                   |   |   |   |-- CellLte.kt  
|       |                   |   |   |   |-- CellNr.kt  
|       |                   |   |   |   |-- CellTdscdma.kt  
|       |                   |   |   |   |-- CellWcdma.kt  
|       |                   |   |   |   |-- ICell.kt  
|       |                   |   |   |   '-- ICellProcessor.kt  
|       |                   |   |   |-- config
|       |                   |   |   |   '-- PhysicalChannelConfig.kt  
|       |                   |   |   |-- connection
|       |                   |   |   |   |-- IConnection.kt  
|       |                   |   |   |   |-- NoneConnection.kt  
|       |                   |   |   |   |-- PrimaryConnection.kt  
|       |                   |   |   |   '-- SecondaryConnection.kt  
|       |                   |   |   |-- model
|       |                   |   |   |   '-- CellError.kt  
|       |                   |   |   '-- signal
|       |                   |   |       |-- ISignal.kt  
|       |                   |   |       |-- SignalCdma.kt  
|       |                   |   |       |-- SignalGsm.kt  
|       |                   |   |       |-- SignalLte.kt  
|       |                   |   |       |-- SignalNr.kt  
|       |                   |   |       |-- SignalTdscdma.kt  
|       |                   |   |       '-- SignalWcdma.kt  
|       |                   |   |-- subscription
|       |                   |   |   |-- ISubscriptionManagerCompat.kt  
|       |                   |   |   |-- SubscriptionManagerCompat14.kt  
|       |                   |   |   |-- SubscriptionManagerCompat22.kt  
|       |                   |   |   '-- mapper
|       |                   |   |       '-- SubscriptionInfoMapper.kt  
|       |                   |   |-- telephony
|       |                   |   |   |-- ITelephonyManagerCompat.kt 
|       |                   |   |   |-- TelephonyManagerCompat14.kt 
|       |                   |   |   |-- TelephonyManagerCompat17.kt  
|       |                   |   |   |-- TelephonyManagerCompat29.kt  
|       |                   |   |   |-- TelephonyManagerCompat30.kt  
|       |                   |   |   |-- mapper
|       |                   |   |   |   |-- CellInfoCallbackMapper.kt  
|       |                   |   |   |   |-- CellInfoMapper.kt  
|       |                   |   |   |   |-- CellLocationMapper.kt 
|       |                   |   |   |   |-- ICellMapper.kt  
|       |                   |   |   |   |-- NeighbouringCellInfoMapper.kt  
|       |                   |   |   |   |-- TelephonyDisplayInfoMapper.kt  
|       |                   |   |   |   '-- cell
|       |                   |   |   |       |-- CellMapperCdma.kt  
|       |                   |   |   |       |-- CellMapperGsm.kt 
|       |                   |   |   |       |-- CellMapperLte.kt 
|       |                   |   |   |       |-- CellMapperNr.kt  
|       |                   |   |   |       |-- CellMapperTdscdma.kt  
|       |                   |   |   |       |-- CellMapperWcdma.kt 
|       |                   |   |   |       |-- ConnectionMapper.kt  
|       |                   |   |   |       '-- SignalStrengthMapper.kt  
|       |                   |   |   '-- network
|       |                   |   |       |-- INetworkGetter.kt  
|       |                   |   |       |-- NetworkOperatorGetter.kt  
|       |                   |   |       '-- SimOperatorGetter.kt  
|       |                   |   '-- util
|       |                   |       |-- Android.kt  
|       |                   |       |-- Collections.kt  
|       |                   |       |-- DirectExecutor.kt  
|       |                   |       |-- Math.kt  
|       |                   |       |-- PhoneStateListenerPort.kt  
|       |                   |       |-- RangeExt.kt  
|       |                   |       |-- Reflection.kt  
|       |                   |       |-- Threads.kt  
|       |                   |       '-- Validation.kt  
|       |                   '-- models
|       |                       |-- CellData.java (13 KB)
|       |                       |-- CellType.java  
|       |                       |-- CellsResponse.java  
|       |                       |-- CellsTypeList.java  
|       |                       |-- SIMInfo.java  
|       |                       |-- SIMInfoResponse.java  
|       |                       |-- SIMManager.kt  
|       |                       |-- cdma
|       |                       |   |-- CellCDMA.java  
|       |                       |   |-- SignalCDMA.java  
|       |                       |   '-- cdma_extentions.kt  
|       |                       |-- common
|       |                       |   |-- Band.java  
|       |                       |   |-- Cell.java  
|       |                       |   |-- Network.java  
|       |                       |   '-- Signal.java  
|       |                       |-- gsm
|       |                       |   |-- BandGSM.java  
|       |                       |   |-- CellGSM.java  
|       |                       |   |-- SignalGSM.java  
|       |                       |   '-- gsm_extentions.kt  
|       |                       |-- lte
|       |                       |   |-- BandLTE.java  
|       |                       |   |-- CellLTE.java  
|       |                       |   |-- SignalLTE.java  
|       |                       |   '-- lte_extentions.kt  
|       |                       |-- nr
|       |                       |   |-- BandNR.java  
|       |                       |   |-- CellNR.java  
|       |                       |   |-- SignalNR.java  
|       |                       |   '-- nr_extentions.kt  
|       |                       |-- tdscdma
|       |                       |   |-- BandTDSCDMA.java  
|       |                       |   |-- CellTDSCDMA.java  
|       |                       |   |-- SignalTDSCDMA.java  
|       |                       |   '-- tdscdma_extentions.kt  
|       |                       '-- wcdma
|       |                           |-- BandWCDMA.java  
|       |                           |-- CellWCDMA.java  
|       |                           |-- SignalWCDMA.java  
|       |                           '-- wcdma_extentions.kt  
|       '-- test
|           '-- kotlin
|               '-- com
|                   '-- example
|                       '-- bheya_network
|                           '-- BheyaNetworkPluginTest.kt  
|-- example
|   |-- README.md  
|   |-- analysis_options.yaml  
|   |-- android
|   |   |-- app
|   |   |   |-- build.gradle  
|   |   |   '-- src
|   |   |       |-- debug
|   |   |       |   '-- AndroidManifest.xml  
|   |   |       |-- main
|   |   |       |   |-- AndroidManifest.xml  
|   |   |       |   |-- kotlin
|   |   |       |   |   '-- com
|   |   |       |   |       '-- example
|   |   |       |   |           '-- bheya_network_example
|   |   |       |   |               '-- MainActivity.kt  
|   |   |       |   '-- res
|   |   |       |       |-- drawable
|   |   |       |       |   '-- launch_background.xml  
|   |   |       |       |-- drawable-v21
|   |   |       |       |   '-- launch_background.xml  
|   |   |       |       |-- mipmap-hdpi
|   |   |       |       |   '-- ic_launcher.png  
|   |   |       |       |-- mipmap-mdpi
|   |   |       |       |   '-- ic_launcher.png  
|   |   |       |       |-- mipmap-xhdpi
|   |   |       |       |   '-- ic_launcher.png  
|   |   |       |       |-- mipmap-xxhdpi
|   |   |       |       |   '-- ic_launcher.png  
|   |   |       |       |-- mipmap-xxxhdpi
|   |   |       |       |   '-- ic_launcher.png  
|   |   |       |       |-- values
|   |   |       |       |   '-- styles.xml  
|   |   |       |       '-- values-night
|   |   |       |           '-- styles.xml  
|   |   |       '-- profile
|   |   |           '-- AndroidManifest.xml  
|   |   |-- build.gradle  
|   |   |-- gradle
|   |   |   '-- wrapper
|   |   |       '-- gradle-wrapper.properties  
|   |   |-- gradle.properties  
|   |   '-- settings.gradle  
|   |-- integration_test
|   |   '-- plugin_integration_test.dart  
|   |-- ios
|   |   |-- Flutter
|   |   |   |-- AppFrameworkInfo.plist  
|   |   |   |-- Debug.xcconfig  
|   |   |   '-- Release.xcconfig  
|   |   |-- Runner
|   |   |   |-- AppDelegate.swift  
|   |   |   |-- Assets.xcassets
|   |   |   |   |-- AppIcon.appiconset
|   |   |   |   |   |-- Contents.json  
|   |   |   |   |   |-- Icon-App-1024x1024@1x.png 
|   |   |   |   |   |-- Icon-App-20x20@1x.png  
|   |   |   |   |   |-- Icon-App-20x20@2x.png  
|   |   |   |   |   |-- Icon-App-20x20@3x.png  
|   |   |   |   |   |-- Icon-App-29x29@1x.png  
|   |   |   |   |   |-- Icon-App-29x29@2x.png  
|   |   |   |   |   |-- Icon-App-29x29@3x.png  
|   |   |   |   |   |-- Icon-App-40x40@1x.png  
|   |   |   |   |   |-- Icon-App-40x40@2x.png  
|   |   |   |   |   |-- Icon-App-40x40@3x.png  
|   |   |   |   |   |-- Icon-App-60x60@2x.png  
|   |   |   |   |   |-- Icon-App-60x60@3x.png  
|   |   |   |   |   |-- Icon-App-76x76@1x.png  
|   |   |   |   |   |-- Icon-App-76x76@2x.png  
|   |   |   |   |   '-- Icon-App-83.5x83.5@2x.png  
|   |   |   |   '-- LaunchImage.imageset
|   |   |   |       |-- Contents.json  
|   |   |   |       |-- LaunchImage.png  
|   |   |   |       |-- LaunchImage@2x.png  
|   |   |   |       |-- LaunchImage@3x.png  
|   |   |   |       '-- README.md  
|   |   |   |-- Base.lproj
|   |   |   |   |-- LaunchScreen.storyboard  
|   |   |   |   '-- Main.storyboard  
|   |   |   |-- Info.plist  
|   |   |   '-- Runner-Bridging-Header.h  
|   |   |-- Runner.xcodeproj
|   |   |   |-- project.pbxproj
|   |   |   |-- project.xcworkspace
|   |   |   |   |-- contents.xcworkspacedata  
|   |   |   |   '-- xcshareddata
|   |   |   |       |-- IDEWorkspaceChecks.plist  
|   |   |   |       '-- WorkspaceSettings.xcsettings  
|   |   |   '-- xcshareddata
|   |   |       '-- xcschemes
|   |   |           '-- Runner.xcscheme  
|   |   |-- Runner.xcworkspace
|   |   |   |-- contents.xcworkspacedata  
|   |   |   '-- xcshareddata
|   |   |       |-- IDEWorkspaceChecks.plist  
|   |   |       '-- WorkspaceSettings.xcsettings  
|   |   '-- RunnerTests
|   |       '-- RunnerTests.swift  
|   |-- lib
|   |   '-- main.dart  
|   |-- pubspec.yaml  
|   '-- test
|       '-- widget_test.dart  
|-- ios
|   |-- Classes
|   |   '-- BheyaNetworkPlugin.swift  
|   '-- bheya_network.podspec  
|-- lib
|   |-- bheya_network.dart  
|   |-- cellResponse.dart  
|   |-- models
|   |   |-- cdma
|   |   |   |-- cdma_band.dart  
|   |   |   |-- cdma_parameters.dart  
|   |   |   '-- cdma_signal.dart  
|   |   |-- common
|   |   |   |-- cell_type.dart  
|   |   |   '-- network.dart  
|   |   |-- gsm
|   |   |   |-- gms_parameters.dart  
|   |   |   |-- gsm_band.dart  
|   |   |   '-- gsm_signal.dart  
|   |   |-- lte
|   |   |   |-- lte_band.dart  
|   |   |   |-- lte_parameters.dart  
|   |   |   '-- lte_signal.dart  
|   |   |-- nr
|   |   |   |-- nr_band.dart  
|   |   |   |-- nr_parameters.dart  
|   |   |   '-- nr_signal.dart  
|   |   |-- tds_cdma
|   |   |   |-- tds_cdma_parameters.dart  
|   |   |   '-- tds_cdma_signal.dart  
|   |   '-- wcdma
|   |       |-- wcdma_band.dart  
|   |       |-- wcdma_parameters.dart  
|   |       '-- wcdma_signal.dart  
|   '-- simInfoResponse.dart  
|-- pubspec.yaml  
'-- test
    |-- bheya_network_method_channel_test.dart  
    '-- bheya_network_test.dart  
Validating package... (5.6s)