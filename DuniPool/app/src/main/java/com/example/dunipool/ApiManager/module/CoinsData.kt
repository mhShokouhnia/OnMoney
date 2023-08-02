package com.example.dunipool.ApiManager.module

import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import kotlinx.android.parcel.RawValue

@Parcelize
data class CoinsData(
    val `data`: List<Data>,
    val hasWarning: Boolean,
    val message: String,
    val metaData: MetaData,
    val rateLimit: RateLimit,
    val sponsoredData: @RawValue List<Any>,
    val type: Int
) : Parcelable {
    @Parcelize
    data class Data(
        val coinInfo: CoinInfo,
        val dISPLAY: DISPLAY,
        val rAW: RAW
    ) : Parcelable {
        @Parcelize
        data class CoinInfo(
            val algorithm: String,
            val assetLaunchDate: String,
            val blockNumber: Int,
            val blockReward: Double,
            val blockTime: Double,
            val documentType: String,
            val fullName: String,
            val id: String,
            val imageUrl: String,
            val `internal`: String,
            val maxSupply: Double,
            val name: String,
            val netHashesPerSecond: Long,
            val proofType: String,
            val rating: Rating,
            val type: Int,
            val url: String
        ) : Parcelable {
            @Parcelize
            data class Rating(
                val weiss: Weiss
            ) : Parcelable {
                @Parcelize
                data class Weiss(
                    val marketPerformanceRating: String,
                    val rating: String,
                    val technologyAdoptionRating: String
                ) : Parcelable
            }
        }

        @Parcelize
        data class DISPLAY(
            val uSD: USD
        ) : Parcelable {
            @Parcelize
            data class USD(
                val cHANGE24HOUR: String,
                val cHANGEDAY: String,
                val cHANGEHOUR: String,
                val cHANGEPCT24HOUR: String,
                val cHANGEPCTDAY: String,
                val cHANGEPCTHOUR: String,
                val cIRCULATINGSUPPLY: String,
                val cIRCULATINGSUPPLYMKTCAP: String,
                val cONVERSIONLASTUPDATE: String,
                val cONVERSIONSYMBOL: String,
                val cONVERSIONTYPE: String,
                val fROMSYMBOL: String,
                val hIGH24HOUR: String,
                val hIGHDAY: String,
                val hIGHHOUR: String,
                val iMAGEURL: String,
                val lASTMARKET: String,
                val lASTTRADEID: String,
                val lASTUPDATE: String,
                val lASTVOLUME: String,
                val lASTVOLUMETO: String,
                val lOW24HOUR: String,
                val lOWDAY: String,
                val lOWHOUR: String,
                val mARKET: String,
                val mKTCAP: String,
                val mKTCAPPENALTY: String,
                val oPEN24HOUR: String,
                val oPENDAY: String,
                val oPENHOUR: String,
                val pRICE: String,
                val sUPPLY: String,
                val tOPTIERVOLUME24HOUR: String,
                val tOPTIERVOLUME24HOURTO: String,
                val tOSYMBOL: String,
                val tOTALTOPTIERVOLUME24H: String,
                val tOTALTOPTIERVOLUME24HTO: String,
                val tOTALVOLUME24H: String,
                val tOTALVOLUME24HTO: String,
                val vOLUME24HOUR: String,
                val vOLUME24HOURTO: String,
                val vOLUMEDAY: String,
                val vOLUMEDAYTO: String,
                val vOLUMEHOUR: String,
                val vOLUMEHOURTO: String
            ) : Parcelable
        }

        @Parcelize
        data class RAW(
            val uSD: USD
        ) : Parcelable {
            @Parcelize
            data class USD(
                val cHANGE24HOUR: Double,
                val cHANGEDAY: Double,
                val cHANGEHOUR: Double,
                val cHANGEPCT24HOUR: Double,
                val cHANGEPCTDAY: Double,
                val cHANGEPCTHOUR: Double,
                val cIRCULATINGSUPPLY: Double,
                val cIRCULATINGSUPPLYMKTCAP: Double,
                val cONVERSIONLASTUPDATE: Int,
                val cONVERSIONSYMBOL: String,
                val cONVERSIONTYPE: String,
                val fLAGS: String,
                val fROMSYMBOL: String,
                val hIGH24HOUR: Double,
                val hIGHDAY: Double,
                val hIGHHOUR: Double,
                val iMAGEURL: String,
                val lASTMARKET: String,
                val lASTTRADEID: String,
                val lASTUPDATE: Int,
                val lASTVOLUME: Double,
                val lASTVOLUMETO: Double,
                val lOW24HOUR: Double,
                val lOWDAY: Double,
                val lOWHOUR: Double,
                val mARKET: String,
                val mEDIAN: Double,
                val mKTCAP: Double,
                val mKTCAPPENALTY: Int,
                val oPEN24HOUR: Double,
                val oPENDAY: Double,
                val oPENHOUR: Double,
                val pRICE: Double,
                val sUPPLY: Double,
                val tOPTIERVOLUME24HOUR: Double,
                val tOPTIERVOLUME24HOURTO: Double,
                val tOSYMBOL: String,
                val tOTALTOPTIERVOLUME24H: Double,
                val tOTALTOPTIERVOLUME24HTO: Double,
                val tOTALVOLUME24H: Double,
                val tOTALVOLUME24HTO: Double,
                val tYPE: String,
                val vOLUME24HOUR: Double,
                val vOLUME24HOURTO: Double,
                val vOLUMEDAY: Double,
                val vOLUMEDAYTO: Double,
                val vOLUMEHOUR: Double,
                val vOLUMEHOURTO: Double
            ) : Parcelable
        }
    }

    @Parcelize
    data class MetaData(
        val count: Int
    ) : Parcelable

    @Parcelize
    class RateLimit : Parcelable
}