package org.globus.cagrid.RProteomics.common;

import java.rmi.RemoteException;

/** 
 *   This class is autogenerated, DO NOT EDIT.
 * 
 * @created by Introduce Toolkit version 1.0
 * 
 */
public interface RProteomicsI {












































































































































































































































































































































































































































































































































































































































































































































     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_log(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_log10(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_log2(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_sqrt(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_square(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_cubeRoot(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_power(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.ExponentType exponent) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_byMax(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_usingMinAndMax(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_IOC(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_quantile(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.QuantileType startQuantile) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] normalize_quantileByValue(edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXml,edu.duke.cabig.rproteomics.domain.serviceinterface.QuantileType startQuantile) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] denoise_MAD(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.PercentileType percentile,edu.duke.cabig.rproteomics.domain.serviceinterface.ValuesNearToCutoffType valuesNearCutoff,edu.duke.cabig.rproteomics.domain.serviceinterface.LambdaType lambda) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] denoise_MADNormalize(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.PercentileType percentile,edu.duke.cabig.rproteomics.domain.serviceinterface.ValuesNearToCutoffType valuesNearCutoff,edu.duke.cabig.rproteomics.domain.serviceinterface.LambdaType lambda,edu.duke.cabig.rproteomics.domain.serviceinterface.NoiseType minNoise) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] denoise_waveletUDWT(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.ThresholdType thresholdMultiplier) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] denoise_waveletUDWTW(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.ThresholdType thresholdMultiplier) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] denoise_waveletUDWTWByValue(edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXml,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.ThresholdType thresholdMultiplier) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] denoise_highPass(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.CoefficientsType numCoeffsToDrop) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] denoise_highPassW(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.CoefficientsType numCoeffsToDrop) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] denoise_PCAFilter(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.CoefficientsType numCoeffsToDrop) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] denoise_q5_PCAFilter(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.CoefficientsType numCoeffsToDrop) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] denoise_loess(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.SpanType span,edu.duke.cabig.rproteomics.domain.serviceinterface.PolynomialDegreeType degree) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] removeBackground_runningQuantile(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.PercentileType percentile) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] removeBackground_runningQuantileByValue(edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXml,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.PercentileType percentile) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] removeBackground_loess(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.SpanType span) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] removeBackground_linearFit(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] removeBackground_exponentialFit(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] removeBackground_logistic(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] removeBackground_quadraticFit(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] removeBackground_minus(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids1,edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids2) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] removeBackground_minusByValue(edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXml1,edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXml2) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.JpegImageType plot_2DStacked(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsidsTop,edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsidsBottom) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.JpegImageType plot_2DStackedByValue(edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXmlTop,edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXmlBottom) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.JpegImageType plot_2D(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.JpegImageType plot_2DByValue(edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXml) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] general_interpolate(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] general_interpolateByValue(edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXml) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] align_alignx(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] align_alignxByValue(edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXml) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] echo(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException ;
     public edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] echoByValue(edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXml) throws RemoteException ;
     public void throwException() throws RemoteException ;

}

