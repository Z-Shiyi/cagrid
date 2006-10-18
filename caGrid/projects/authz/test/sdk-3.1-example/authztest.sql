-- MySQL dump 10.10
--
-- Host: localhost    Database: authztest
-- ------------------------------------------------------
-- Server version	5.0.22-standard

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CHROMOSOME`
--

DROP TABLE IF EXISTS `CHROMOSOME`;
CREATE TABLE `CHROMOSOME` (
  `CHROMOSOME_ID` decimal(10,0) NOT NULL default '0',
  `CHROMOSOME_NUMBER` varchar(50) NOT NULL default '',
  `TAXON_ID` decimal(10,0) NOT NULL default '0',
  PRIMARY KEY  (`CHROMOSOME_ID`),
  KEY `idx_TAXON_ID` (`TAXON_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CHROMOSOME`
--


/*!40000 ALTER TABLE `CHROMOSOME` DISABLE KEYS */;
LOCK TABLES `CHROMOSOME` WRITE;
INSERT INTO `CHROMOSOME` VALUES ('0','8','5'),('1','4','5'),('2','19','5'),('3','12','5'),('4','14','5'),('5','18','5'),('6','9','5'),('7','11','5'),('8','1','5'),('9','6','5'),('10','7','5'),('11','X','5'),('12','2','5'),('13','21','5'),('14','3','5'),('15','20','5'),('16','16','5'),('17','13','5'),('18','22','5'),('19','17','5'),('20','15','5'),('21','10','5'),('22','5','5'),('23','Y','5'),('24','YX','5'),('25','3','6'),('26','6','6'),('27','2','6'),('28','1','6'),('29','10','6'),('30','7','6'),('31','12','6'),('32','11','6'),('33','13','6'),('34','16','6'),('35','15','6'),('36','X','6'),('37','8','6'),('38','5','6'),('39','17','6'),('40','4','6'),('41','18','6'),('42','9','6'),('43','14','6'),('44','19','6'),('45','Y','6'),('46','YX','6'),('52','U','5'),('53','Un','5'),('54','Un','6'),('55','20','6'),('58','22','6'),('59','MT','6'),('60','?','5'),('61','MT','5');
UNLOCK TABLES;
/*!40000 ALTER TABLE `CHROMOSOME` ENABLE KEYS */;

--
-- Table structure for table `CLONE`
--

DROP TABLE IF EXISTS `CLONE`;
CREATE TABLE `CLONE` (
  `CLONE_ID` decimal(10,0) NOT NULL default '0',
  `INSERT_SIZE` decimal(10,0) default NULL,
  `CLONE_NAME` varchar(50) default NULL,
  `VERSION` varchar(100) default NULL,
  `ACCESSION_NUMBER` varchar(15) default NULL,
  `CLONE_STRAIN` varchar(50) default NULL,
  `LIBRARY_ID` decimal(10,0) default NULL,
  `VERIFIED` tinyint(1) default NULL,
  PRIMARY KEY  (`CLONE_ID`),
  KEY `idx_LIBRARY_ID` (`LIBRARY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CLONE`
--


/*!40000 ALTER TABLE `CLONE` DISABLE KEYS */;
LOCK TABLES `CLONE` WRITE;
INSERT INTO `CLONE` VALUES ('2',NULL,'IMAGE:4734378',NULL,NULL,NULL,'17904',NULL),('3',NULL,'unknown',NULL,NULL,NULL,'37954',NULL),('4',NULL,'IMAGE:4767316',NULL,NULL,NULL,'17904',NULL),('5',NULL,'GLCFOG07',NULL,NULL,NULL,'18970',NULL),('6',NULL,'IMAGE:1870937',NULL,NULL,NULL,'54',NULL),('7',NULL,'GKCFZH06',NULL,NULL,NULL,'19904',NULL),('8',NULL,'IMAGE:4722638',NULL,NULL,NULL,'17904',NULL),('9',NULL,'IMAGE:2151449',NULL,NULL,NULL,'1595',NULL),('10',NULL,'HSI08034',NULL,NULL,NULL,'38088',NULL),('11',NULL,'IMAGE:4712210',NULL,NULL,NULL,'17904',NULL),('12',NULL,'IMAGE:4716802',NULL,NULL,NULL,'17904',NULL),('13',NULL,'IMAGE:4712733',NULL,NULL,NULL,'17904',NULL),('14',NULL,'IMAGE:4072143',NULL,NULL,NULL,'17904',NULL),('15',NULL,'GLCFOD10',NULL,NULL,NULL,'18970',NULL),('16',NULL,'L17N670205n1-41-A04',NULL,NULL,NULL,'29975',NULL),('17',NULL,'UI-H-FG1-bgl-g-02-0-UI',NULL,NULL,NULL,'27590',NULL),('18',NULL,'HSI05750',NULL,NULL,NULL,'38088',NULL),('21',NULL,'unknown',NULL,NULL,NULL,'22020',NULL),('23',NULL,'L17N670205n1-15-F12',NULL,NULL,NULL,'29975',NULL),('24',NULL,'IMAGE:4722596',NULL,NULL,NULL,'17904',NULL),('25',NULL,'IMAGp998I184581_,_IMAGE:1870937',NULL,NULL,NULL,'54',NULL),('26',NULL,'HSI15615',NULL,NULL,NULL,'38088',NULL),('27',NULL,'GLCGHF10',NULL,NULL,NULL,'18970',NULL),('29',NULL,'GLCGYF12',NULL,NULL,NULL,'18970',NULL),('32',NULL,'GLCBSG03',NULL,NULL,NULL,'18970',NULL),('39',NULL,'GLCGWH09',NULL,NULL,NULL,'18970',NULL),('94859',NULL,'IMAGE:1568398',NULL,NULL,NULL,'53',NULL),('138079',NULL,'IMAGE:1568339',NULL,NULL,NULL,'53',NULL),('231233',NULL,'IMAGE:1568374',NULL,NULL,NULL,'53',NULL),('303475',NULL,'IMAGE:1568345',NULL,NULL,NULL,'53',NULL),('358604',NULL,'IMAGE:1568329',NULL,NULL,NULL,'53',NULL),('602311',NULL,'IMAGE:1568322',NULL,NULL,NULL,'53',NULL),('647980',NULL,'IMAGE:1568309',NULL,NULL,NULL,'53',NULL),('828728',NULL,'IMAGE:1568302',NULL,NULL,NULL,'53',NULL),('922636',NULL,'IMAGE:1568313',NULL,NULL,NULL,'53',NULL),('967079',NULL,'IMAGE:1568341',NULL,NULL,NULL,'53',NULL),('968080',NULL,'IMAGE:1568317',NULL,NULL,NULL,'53',NULL),('1022567',NULL,'IMAGE:1568319',NULL,NULL,NULL,'53',NULL),('1072210',NULL,'IMAGE:1568333',NULL,NULL,NULL,'53',NULL),('1074659',NULL,'IMAGE:1568354',NULL,NULL,NULL,'53',NULL),('1487580',NULL,'IMAGE:1568394',NULL,NULL,NULL,'53',NULL),('1736998',NULL,'IMAGE:1568386',NULL,NULL,NULL,'53',NULL),('1839276',NULL,'IMAGE:1568390',NULL,NULL,NULL,'53',NULL),('1869910',NULL,'IMAGE:1568337',NULL,NULL,NULL,'53',NULL),('2049349',NULL,'IMAGE:1568340',NULL,NULL,NULL,'53',NULL),('2096237',NULL,'IMAGE:1568328',NULL,NULL,NULL,'53',NULL),('2323237',NULL,'IMAGE:1568346',NULL,NULL,NULL,'53',NULL),('2400116',NULL,'IMAGE:1568304',NULL,NULL,NULL,'53',NULL),('2448912',NULL,'IMAGE:1568377',NULL,NULL,NULL,'53',NULL),('2543057',NULL,'IMAGE:1568316',NULL,NULL,NULL,'53',NULL),('2543070',NULL,'IMAGE:1568314',NULL,NULL,NULL,'53',NULL),('2565601',NULL,'IMAGE:1568325',NULL,NULL,NULL,'53',NULL),('2633004',NULL,'IMAGE:1568385',NULL,NULL,NULL,'53',NULL),('2633551',NULL,'IMAGE:1568380',NULL,NULL,NULL,'53',NULL),('2662132',NULL,'IMAGE:1568353',NULL,NULL,NULL,'53',NULL),('2674495',NULL,'IMAGE:1568347',NULL,NULL,NULL,'53',NULL),('2784192',NULL,'IMAGE:1568318',NULL,NULL,NULL,'53',NULL),('2811051',NULL,'IMAGE:1568397',NULL,NULL,NULL,'53',NULL),('2885395',NULL,'IMAGE:1568308',NULL,NULL,NULL,'53',NULL),('2890225',NULL,'IMAGE:1568344',NULL,NULL,NULL,'53',NULL),('2907043',NULL,'IMAGE:1568338',NULL,NULL,NULL,'53',NULL),('3162052',NULL,'IMAGE:1568356',NULL,NULL,NULL,'53',NULL),('3272443',NULL,'IMAGE:1568349',NULL,NULL,NULL,'53',NULL),('3314469',NULL,'IMAGE:1568334',NULL,NULL,NULL,'53',NULL),('3355636',NULL,'IMAGE:1568352',NULL,NULL,NULL,'53',NULL),('3413081',NULL,'IMAGE:1568350',NULL,NULL,NULL,'53',NULL),('3498814',NULL,'IMAGE:1568330',NULL,NULL,NULL,'53',NULL),('3616172',NULL,'IMAGE:1568343',NULL,NULL,NULL,'53',NULL),('3673297',NULL,'IMAGE:1568391',NULL,NULL,NULL,'53',NULL),('3686393',NULL,'IMAGE:1568365',NULL,NULL,NULL,'53',NULL),('4163711',NULL,'IMAGE:1568306',NULL,NULL,NULL,'53',NULL),('4207442',NULL,'IMAGE:1568320',NULL,NULL,NULL,'53',NULL),('4233871',NULL,'IMAGE:1568303',NULL,NULL,NULL,'53',NULL),('4295652',NULL,'IMAGE:1568315',NULL,NULL,NULL,'53',NULL),('4458359',NULL,'IMAGE:1568301',NULL,NULL,NULL,'53',NULL),('4595890',NULL,'IMAGE:1568312',NULL,NULL,NULL,'53',NULL),('4688140',NULL,'IMAGE:1568307',NULL,NULL,NULL,'53',NULL),('4699930',NULL,'IMAGE:1568378',NULL,NULL,NULL,'53',NULL),('4737221',NULL,'IMAGE:1568335',NULL,NULL,NULL,'53',NULL),('4756620',NULL,'IMAGE:1568373',NULL,NULL,NULL,'53',NULL),('4811447',NULL,'IMAGE:1568395',NULL,NULL,NULL,'53',NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `CLONE` ENABLE KEYS */;

--
-- Table structure for table `GENE`
--

DROP TABLE IF EXISTS `GENE`;
CREATE TABLE `GENE` (
  `GENE_ID` decimal(10,0) NOT NULL default '0',
  `CLUSTER_ID` decimal(10,0) default NULL,
  `GENE_TITLE` varchar(50) default NULL,
  `LOCUS_LINK_ID` varchar(50) default NULL,
  `GENE_SYMBOL` varchar(50) default NULL,
  `OMIM_ID` varchar(50) default NULL,
  `LOCUS_LINK_SUMMARY` text,
  `CHROMOSOME_ID` decimal(10,0) default NULL,
  `TAXON_ID` decimal(10,0) default NULL,
  PRIMARY KEY  (`GENE_ID`),
  KEY `idx_CHROMOSOME_ID` (`CHROMOSOME_ID`),
  KEY `idx_TAXON_ID` (`TAXON_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `GENE`
--


/*!40000 ALTER TABLE `GENE` DISABLE KEYS */;
LOCK TABLES `GENE` WRITE;
INSERT INTO `GENE` VALUES ('2','2','N-acetyltransferase 2 (arylamine N-acetyltransfera','10','NAT2','243400',NULL,'0','5'),('3','4','Alcohol dehydrogenase IB (class I), beta polypepti','125','ADH1B','103720',NULL,'1','5'),('4','11','Carcinoembryonic antigen-related cell adhesion mol','1084','CEACAM3',NULL,NULL,'2','5'),('5','12','Carcinoembryonic antigen-related cell adhesion mol','1089','CEACAM4',NULL,NULL,'2','5'),('6','21','Elastase 2A','63036','ELA2A',NULL,NULL,'8','5'),('7','36','Lymphotoxin alpha (TNF superfamily, member 1)','4049','LTA','153440',NULL,'9','5'),('8','41','Carcinoembryonic antigen-related cell adhesion mol','1088','CEACAM8',NULL,NULL,'2','5'),('9','46','Platelet-activating factor receptor','5724','PTAFR','173393',NULL,'8','5'),('10','56','Phosphoribosyl pyrophosphate synthetase 1','5631','PRPS1','311850',NULL,'11','5'),('11','66','Interleukin 1 receptor-like 1','9173','IL1RL1','601203',NULL,'12','5'),('12','84','Interleukin 2 receptor, gamma (severe combined imm','3561','IL2RG','308380',NULL,'11','5'),('13','96','Phorbol-12-myristate-13-acetate-induced protein 1','5366','PMAIP1','604959',NULL,'5','5'),('14','101','Cytochrome P450, family 4, subfamily F, polypeptid','8529','CYP4F2','604426',NULL,'2','5'),('15','102','Aminomethyltransferase (glycine cleavage system pr','275','AMT','238310',NULL,'14','5'),('16','104','HGF activator','3083','HGFAC','604552',NULL,'1','5'),('17','109','Dipeptidase 1 (renal)','1800','DPEP1','179780',NULL,'16','5'),('18','110','Putative prolyl oligopeptidase','9581','KIAA0436',NULL,NULL,'12','5'),('19','111','Fibroblast growth factor 9 (glia-activating factor','2254','FGF9','600921',NULL,'17','5'),('20','120','Peroxiredoxin 6','9588','PRDX6','602316',NULL,'8','5'),('21','129','Cholecystokinin A receptor','886','CCKAR','118444',NULL,'1','5'),('22','142','Sulfotransferase family, cytosolic, 1A, phenol-pre','6817','SULT1A1','171150',NULL,'16','5'),('23','184','Advanced glycosylation end product-specific recept','177','AGER','600214',NULL,'9','5'),('24','202','Benzodiazapine receptor (peripheral)','706','BZRP','109610',NULL,'18','5'),('25','203','Cholecystokinin B receptor','887','CCKBR','118445',NULL,'7','5'),('26','208','Glucagon receptor','2642','GCGR','138033',NULL,'19','5'),('27','239','Forkhead box M1','2305','FOXM1','602341',NULL,'3','5'),('28','240','M-phase phosphoprotein 1','9585','MPHOSPH1','605498',NULL,'21','5'),('29','250','Xanthine dehydrogenase','7498','XDH','607633',NULL,'12','5'),('30','264','Patatin-like phospholipase domain containing 4','8228','PNPLA4','300102',NULL,'11','5'),('31','266','POU domain, class 4, transcription factor 2','5458','POU4F2','113725',NULL,'1','5'),('32','270','Pleckstrin homology, Sec7 and coiled-coil domains,','9595','PSCDBP','604448',NULL,'12','5'),('33','308','Arrestin 3, retinal (X-arrestin)','407','ARR3','301770',NULL,'11','5'),('34','313','Secreted phosphoprotein 1 (osteopontin, bone sialo','6696','SPP1','166490',NULL,'1','5'),('35','315','Mucin 2, intestinal/tracheal','4583','MUC2','158370',NULL,'7','5'),('36','326','TAR (HIV) RNA binding protein 2','6895','TARBP2','605053',NULL,'3','5'),('37','334','Rho guanine nucleotide exchange factor (GEF) 5','7984','ARHGEF5','600888',NULL,'10','5'),('38','339','Purinergic receptor P2Y, G-protein coupled, 2','5029','P2RY2','600041',NULL,'7','5'),('39','351','T-complex 10 (mouse)','6953','TCP10','187020',NULL,'9','5'),('40','352','Folate receptor 3 (gamma)','2352','FOLR3','602469',NULL,'7','5'),('41','366','Hypothetical protein MGC27165','283650','MGC27165',NULL,NULL,'4','5'),('42','372','Opioid receptor, delta 1','4985','OPRD1','165195',NULL,'8','5'),('43','389','Alcohol dehydrogenase 7 (class IV), mu or sigma po','131','ADH7','600086',NULL,'1','5'),('44','395','Monocyte chemotactic protein-1 (MCP-1) receptor',NULL,'null',NULL,NULL,'14','5'),('45','406','Solute carrier family 6 (neurotransmitter transpor','6531','SLC6A3','126455',NULL,'22','5'),('46','419','Distal-less homeo box 2','1746','DLX2','126255',NULL,'12','5'),('47','423','Pancreatitis-associated protein','5068','PAP','167805',NULL,'12','5'),('48','428','Fms-related tyrosine kinase 3 ligand','2323','FLT3LG','600007',NULL,'2','5'),('49','429','ATP synthase, H+ transporting, mitochondrial F0 co','518','ATP5G3','602736',NULL,'12','5'),('50','437','Transcription factor 15 (basic helix-loop-helix)','6939','TCF15','601010',NULL,'15','5'),('51','438','Mesenchyme homeo box 1','4222','MEOX1','600147',NULL,'19','5'),('52','456','Leukotriene C4 synthase','4056','LTC4S','246530',NULL,'22','5'),('53','457','Fucosyltransferase 7 (alpha (1,3) fucosyltransfera','2529','FUT7','602030',NULL,'6','5'),('54','460','Activating transcription factor 3','467','ATF3','603148',NULL,'8','5'),('55','477','Hydroxysteroid (17-beta) dehydrogenase 3','3293','HSD17B3','605573',NULL,'6','5'),('56','502','Transporter 2, ATP-binding cassette, sub-family B','6891','TAP2','170261',NULL,'9','5'),('57','505','ISL1 transcription factor, LIM/homeodomain, (islet','3670','ISL1','600366',NULL,'22','5'),('58','550','Phosducin','5132','PDC','171490',NULL,'8','5'),('59','552','Steroid-5-alpha-reductase, alpha polypeptide 1 (3-','6715','SRD5A1','184753',NULL,'22','5'),('60','557','Adrenergic, alpha-1D-, receptor','146','ADRA1D','104219',NULL,'15','5'),('61','560','Apolipoprotein B mRNA editing enzyme, catalytic po','339','APOBEC1','600130',NULL,'3','5'),('62','624','Interleukin 8','3576','IL8','146930',NULL,'1','5'),('63','635','Calcium channel, voltage-dependent, beta 1 subunit','782','CACNB1','114207',NULL,'19','5'),('64','639','S100 calcium binding protein G','795','S100G','302020',NULL,'11','5'),('65','646','Carboxypeptidase A3 (mast cell)','1359','CPA3','114851',NULL,'14','5'),('66','652','Tumor necrosis factor (ligand) superfamily, member','959','TNFSF5','300386',NULL,'11','5'),('67','656','Cell division cycle 25C','995','CDC25C','157680',NULL,'22','5'),('68','673','Interleukin 12A (natural killer cell stimulatory f','3592','IL12A','161560',NULL,'14','5'),('69','674','Interleukin 12B (natural killer cell stimulatory f','3593','IL12B','161561',NULL,'22','5'),('70','692','Tumor-associated calcium signal transducer 1','4072','TACSTD1','185535',NULL,'12','5'),('71','694','Interleukin 3 (colony-stimulating factor, multiple','3562','IL3','147740',NULL,'22','5'),('72','695','Cystatin B (stefin B)','1476','CSTB','601145',NULL,'13','5'),('73','707','Keratin 2A (epidermal ichthyosis bullosa of Siemen','3849','KRT2A','600194',NULL,'3','5'),('74','709','Deoxycytidine kinase','1633','DCK','125450',NULL,'1','5'),('75','711','Defensin, alpha 6, Paneth cell-specific','1671','DEFA6','600471',NULL,'0','5'),('76','724','Thyroid hormone receptor, alpha (erythroblastic le','7067','THRA','190120',NULL,'19','5'),('77','728','Ribonuclease, RNase A family, 2 (liver, eosinophil','6036','RNASE2','131410',NULL,'4','5'),('78','744','Ferredoxin 1','2230','FDX1','103260',NULL,'7','5'),('79','753','Formyl peptide receptor 1','2357','FPR1','136537',NULL,'2','5'),('80','765','GATA binding protein 1 (globin transcription facto','2623','GATA1','305371',NULL,'11','5'),('81','767','Growth hormone releasing hormone receptor','2692','GHRHR','139191',NULL,'10','5'),('82','778','Guanylate cyclase activator 2A (guanylin)','2980','GUCA2A','139392',NULL,'8','5'),('83','784','Epstein-Barr virus induced GENE 2 (lymphocyte-spec','1880','EBI2','605741',NULL,'17','5'),('84','789','Chemokine (C-X-C motif) ligand 1 (melanoma growth','2919','CXCL1','155730',NULL,'1','5'),('85','792','Tripartite motif-containing 23','373','TRIM23','601747',NULL,'22','5'),('86','799','Diphtheria toxin receptor (heparin-binding epiderm','1839','DTR','126150',NULL,'22','5'),('87','808','HeteroGENEous nuclear ribonucleoprotein F','3185','HNRPF','601037',NULL,'21','5'),('88','820','Homeo box C6','3223','HOXC6','142972',NULL,'3','5'),('89','821','Biglycan','633','BGN','301870',NULL,'11','5'),('90','825','Hydroxy-delta-5-steroid dehydrogenase, 3 beta- and','3284','HSD3B2','201810',NULL,'8','5'),('91','838','CD80 antigen (CD28 antigen ligand 1, B7-1 antigen)','941','CD80','112203',NULL,'14','5'),('92','839','Insulin-like growth factor binding protein, acid l','3483','IGFALS','601489',NULL,'16','5'),('93','840','Indoleamine-pyrrole 2,3 dioxygenase','3620','INDO','147435',NULL,'0','5'),('94','845','Interleukin 13','3596','IL13','147683',NULL,'22','5'),('95','846','Interleukin 8 receptor, beta','3579','IL8RB','146928',NULL,'12','5'),('96','856','Interferon, gamma','3458','IFNG','147570',NULL,'3','5'),('97','861','Mitogen-activated protein kinase 3','5595','MAPK3','601795',NULL,'16','5'),('98','878','Sorbitol dehydrogenase','6652','SORD','182500',NULL,'20','5'),('99','889','Charcot-Leyden crystal protein','1178','CLC','153310',NULL,'2','5'),('100','897','Fc fragment of IgE, high affinity I, receptor for;','2205','FCER1A','147140',NULL,'8','5'),('101','904','Amylo-1, 6-glucosidase, 4-alpha-glucanotransferase','178','AGL','232400',NULL,'8','5'),('102','920','AT rich interactive domain 5A (MRF1-like)','10865','ARID5A',NULL,NULL,'12','5'),('103','924','Crystallin, mu','1428','CRYM','123740',NULL,'16','5'),('104','926','Myxovirus (influenza virus) resistance 2 (mouse)','4600','MX2','147890',NULL,'13','5'),('105','927','Myosin binding protein H','4608','MYBPH','160795',NULL,'8','5'),('106','928','Proteinase 3 (serine proteinase, neutrophil, Wegen','5657','PRTN3','177020',NULL,'2','5'),('107','929','Myosin, heavy polypeptide 7, cardiac muscle, beta','4625','MYH7','160760',NULL,'4','5'),('108','931','Myosin, heavy polypeptide 2, skeletal muscle, adul','4620','MYH2','160740',NULL,'19','5'),('109','936','Solute carrier family 34 (sodium phosphate), membe','6569','SLC34A1','182309',NULL,'22','5'),('110','942','Tachykinin receptor 3','6870','TACR3','162332',NULL,'1','5'),('111','943','Natural killer cell transcript 4','9235','NK4','606001',NULL,'16','5'),('112','952','Solute carrier family 10 (sodium/bile acid cotrans','6554','SLC10A1','182396',NULL,'4','5'),('113','960','Interleukin 9','3578','IL9','146931',NULL,'22','5'),('114','992','Phospholipase A2, group IB (pancreas)','5319','PLA2G1B','172410',NULL,'3','5'),('115','997','26 serine protease','8909','P11','606720',NULL,'3','5'),('116','1004','Bromodomain and PHD finger containing, 1','7862','BRPF1','602410',NULL,'14','5'),('117','1011','Protein Z, vitamin K-dependent plasma glycoprotein','8858','PROZ','176895',NULL,'17','5'),('118','1012','Complement component 4 binding protein, alpha','722','C4BPA','120830',NULL,'8','5'),('119','1019','Parathyroid hormone receptor 1','5745','PTHR1','168468',NULL,'14','5');
UNLOCK TABLES;
/*!40000 ALTER TABLE `GENE` ENABLE KEYS */;

--
-- Table structure for table `GENE_SEQUENCE`
--

DROP TABLE IF EXISTS `GENE_SEQUENCE`;
CREATE TABLE `GENE_SEQUENCE` (
  `GENE_ID` decimal(10,0) NOT NULL default '0',
  `SEQUENCE_ID` decimal(10,0) NOT NULL default '0',
  PRIMARY KEY  (`GENE_ID`,`SEQUENCE_ID`),
  KEY `idx_GENE_ID` (`GENE_ID`),
  KEY `idx_SEQUENCE_ID` (`SEQUENCE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `GENE_SEQUENCE`
--


/*!40000 ALTER TABLE `GENE_SEQUENCE` DISABLE KEYS */;
LOCK TABLES `GENE_SEQUENCE` WRITE;
INSERT INTO `GENE_SEQUENCE` VALUES ('2','2'),('2','3'),('2','4'),('2','5'),('2','7'),('2','8'),('2','9'),('2','11'),('2','12'),('2','13'),('2','14'),('2','15'),('2','17'),('2','18'),('2','19'),('2','20'),('2','21'),('2','22'),('2','23'),('2','24'),('2','25'),('2','26'),('2','27'),('2','31'),('2','32'),('3','33'),('3','35'),('3','38'),('3','45'),('3','185');
UNLOCK TABLES;
/*!40000 ALTER TABLE `GENE_SEQUENCE` ENABLE KEYS */;

--
-- Table structure for table `GENE_TARGET`
--

DROP TABLE IF EXISTS `GENE_TARGET`;
CREATE TABLE `GENE_TARGET` (
  `GENE_ID` decimal(10,0) NOT NULL default '0',
  `TARGET_ID` decimal(10,0) NOT NULL default '0',
  PRIMARY KEY  (`GENE_ID`,`TARGET_ID`),
  KEY `idx_GENE_ID` (`GENE_ID`),
  KEY `idx_TARGET_ID` (`TARGET_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `GENE_TARGET`
--


/*!40000 ALTER TABLE `GENE_TARGET` DISABLE KEYS */;
LOCK TABLES `GENE_TARGET` WRITE;
INSERT INTO `GENE_TARGET` VALUES ('70','22');
UNLOCK TABLES;
/*!40000 ALTER TABLE `GENE_TARGET` ENABLE KEYS */;

--
-- Table structure for table `LIBRARY`
--

DROP TABLE IF EXISTS `LIBRARY`;
CREATE TABLE `LIBRARY` (
  `LIBRARY_ID` decimal(10,0) NOT NULL default '0',
  `LIBRARY_TYPE` varchar(50) default NULL,
  `LIBRARY_NAME` varchar(50) default NULL,
  `DESCRIPTION` varchar(50) default NULL,
  `KEYWORD` varchar(50) default NULL,
  `R_SITE_1` varchar(50) default NULL,
  `R_SITE_2` varchar(50) default NULL,
  `SEQUENCES_TO_DATE` decimal(10,0) default NULL,
  `CLONES_TO_DATE` decimal(10,0) default NULL,
  `UNIGENE_ID` decimal(10,0) default NULL,
  `CREATE_DATE` date default NULL,
  `LAB_HOST` varchar(50) default NULL,
  PRIMARY KEY  (`LIBRARY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `LIBRARY`
--


/*!40000 ALTER TABLE `LIBRARY` DISABLE KEYS */;
LOCK TABLES `LIBRARY` WRITE;
INSERT INTO `LIBRARY` VALUES ('1',NULL,'NCI_CGAP_Pr1','1st strand cDNA was primed with oligo(dT)17 on 50','prostate, epithelium, normal, non-normalized, micr','Not1','EcoRI','6010','6528','573',NULL,'DH10B'),('2',NULL,'NCI_CGAP_Pr2','1st strand cDNA was primed with oligo(dT)17 on 50','prostate, low grade, preneoplasia, non-normalized,','Not1','EcoRI','5931','8448','574',NULL,'DH10B'),('3',NULL,'NCI_CGAP_Pr3','1st strand cDNA was primed with oligo(dT)17 on 50','prostate, invasive, adenocarcinoma, non-normalized','Not1','EcoRI','5519','8064','575',NULL,'DH10B'),('4',NULL,'NCI_CGAP_Pr4','mRNA made from prostate intraepithelial neoplasia','prostate, high grade, preneoplasia, non-normalized',NULL,NULL,'667','1536','934',NULL,'DH10B'),('5',NULL,'NCI_CGAP_Ov1','Cloned unidirectionally.  Primer: Oligo dT.','ovary, serous, papillary, adenocarcinoma, non-norm','SalI','NotI','199','768','999',NULL,'DH10B'),('6',NULL,'NCI_CGAP_AR1','Cloned unidirectionally.  Primer: Oligo dT.','skeletal muscle, alveolar, rhabdomyosarcoma, non-n','SalI','NotI','357','384','996',NULL,'DH10B'),('7',NULL,'NCI_CGAP_Co1','Cloned unidirectionally.  Primer: Oligo dT.','moderately differentiated, adenocarcinoma, non-nor','SalI','NotI','302','1920','997',NULL,'DH10B'),('8',NULL,'NCI_CGAP_GC1','Cloned unidirectionally.  Primer: Oligo dT.','germ cell, seminoma, non-normalized, bulk, CGAP, E','SalI','NotI','521','3840','998',NULL,'DH10B'),('9',NULL,'NCI_CGAP_GC2','Cloned unidirectionally.  Primer: Oligo dT. Bulk g','germ cell, neoplasia, non-normalized, bulk, CGAP,','EcoRI','XhoI','1495','3456','939',NULL,'SOLR (kanamycin resistant)'),('11',NULL,'NCI_CGAP_Co2','Cloned unidirectionally.  Primer: Oligo dT. Bulk c','villous, non-normalized, colon, bulk, CGAP, EST, S','EcoRI','XhoI','933','1152','937',NULL,'SOLR (kanamycin resistant)'),('12',NULL,'NCI_CGAP_Lu1','Cloned unidirectionally.  Primer: Oligo dT.  Bulk','lung, poorly differentiated, neoplasia, non-normal','EcoRI','XhoI','2243','3456','914',NULL,'SOLR (kanamycin resistant)'),('13',NULL,'NCI_CGAP_Sch1','Cloned unidirectionally.  Primer: Oligo dT. Two po','nerve, schwannoma, non-normalized, bulk, CGAP, EST','EcoRI','XhoI','1220','2304','941',NULL,'SOLR (kanamycin resistant)'),('14',NULL,'NCI_CGAP_AA1','Cloned unidirectionally.  Primer: Oligo dT. Two po','adrenal cortex, non-normalized, bulk, CGAP, EST, S','EcoRI','XhoI','3363','4608','927',NULL,'SOLR (kanamycin resistant)'),('15',NULL,'NCI_CGAP_Co3','1st strand cDNA was prepared from 12 pooled bulk t','neoplasia, colon, bulk, normalized, CGAP, EST, Soa','Not I','Eco RI','13591','20736','882',NULL,'DH10B'),('16',NULL,'NCI_CGAP_Pr5','mRNA made from normal prostatic epithelial cells,','prostate, normal, non-normalized, microdissected,',NULL,NULL,'832','1536','891',NULL,'DH10B'),('17',NULL,'NCI_CGAP_Pr6','mRNA made from prostatic intraepithelial neoplasia','prostate, low grade, preneoplasia, non-normalized,',NULL,NULL,'1493','2304','888',NULL,'DH10B'),('18',NULL,'NCI_CGAP_Pr7','mRNA made from prostate intraepithelial neoplasia','prostate, high grade, preneoplasia, non-normalized',NULL,NULL,'474','768','940',NULL,'DH10B'),('19',NULL,'NCI_CGAP_Pr8','mRNA made from invasive prostate tumor, cDNA made','prostate, invasive, adenocarcinoma, non-normalized',NULL,NULL,'1121','1920','892',NULL,'DH10B'),('20',NULL,'NCI_CGAP_Pr9','mRNA made from normal prostatic epithelial cells,','prostate, epithelium, normal, non-normalized, micr',NULL,NULL,'1131','1920','925',NULL,'DH10B'),('21',NULL,'NCI_CGAP_Pr10','mRNA made from invasive prostate tumor, cDNA made','prostate, invasive, adenocarcinoma, non-normalized',NULL,NULL,'1162','1920','926',NULL,'DH10B'),('22',NULL,'NCI_CGAP_Pr11','mRNA made from normal prostatic epithelial cells,','prostate, epithelium, normal, non-normalized, micr',NULL,NULL,'1406','2304','928',NULL,'DH10B'),('23',NULL,'NCI_CGAP_Pr12','mRNA made from metastatic prostate lesion of the b','metastasis, prostate, adenocarcinoma, non-normaliz',NULL,NULL,'4492','7680','919',NULL,'DH10B'),('24',NULL,'NCI_CGAP_Li1','mRNA made from normal liver hepatocytes, cDNA made','non-normalized, uncharacterized tissue, uncharacte',NULL,NULL,'504','1152','884',NULL,'DH10B'),('25',NULL,'NCI_CGAP_Li2','mRNA made from invasive hepatocellular carcinoma,','non-normalized, uncharacterized tissue, uncharacte',NULL,NULL,'309','1152','885',NULL,'DH10B'),('26',NULL,'NCI_CGAP_Lip2','mRNA made from liposarcoma, cDNA made by oligo-dT','adipose, well differentiated, liposarcoma, non-nor',NULL,NULL,'1740','2688','886',NULL,'DH10B'),('27',NULL,'NCI_CGAP_Kid1','mRNA made from invasive kidney tumor, cDNA made by','kidney, papillary, renal cell carcinoma, non-norma',NULL,NULL,'1137','1920','890',NULL,'DH10B'),('28',NULL,'NCI_CGAP_Thy1','mRNA made from invasive thyroid tumor, cDNA made b','thyroid, papillary, carcinoma, non-normalized, bul',NULL,NULL,'2484','2688','889',NULL,'DH10B'),('29',NULL,'NCI_CGAP_Ov2','mRNA made from invasive ovarian tumor, cDNA made b','ovary, serous, papillary, adenocarcinoma, non-norm',NULL,NULL,'4162','4224','887',NULL,'DH10B'),('30',NULL,'NCI_CGAP_Alv1','mRNA made from alveolar rhabdomyosarcoma, cDNA mad','skeletal muscle, alveolar, rhabdomyosarcoma, non-n',NULL,NULL,'4907','8064','881',NULL,'DH10B'),('31',NULL,'NCI_CGAP_Ew1','mRNA made from Ewing\'s sarcoma, cDNA made by oligo','Ewing\'s sarcoma, non-normalized, bulk, CGAP, EST,',NULL,NULL,'5441','10752','883',NULL,'DH10B'),('32',NULL,'NCI_CGAP_Co4','1st strand cDNA was prepared from pooled colon tum','neoplasia, non-normalized, colon, bulk, CGAP, EST,',NULL,NULL,'726','1536','896',NULL,'DH10B'),('33',NULL,'NCI_CGAP_Pr21','1st strand cDNA was prepared from normal prostate','prostate, normal, non-normalized, bulk, CGAP, EST,',NULL,NULL,'1296','1920','924',NULL,'DH10B'),('34',NULL,'NCI_CGAP_Pr22','1st strand cDNA was prepared from normal prostate','prostate, normal, bulk, normalized, CGAP, EST, Soa',NULL,NULL,'8656','13056','910',NULL,'DH10B'),('35',NULL,'NCI_CGAP_Br1.1','1st strand cDNA was prepared from pooled bulk brea','mammary gland, carcinoma, non-normalized, bulk, CG',NULL,NULL,'2161','3456','894',NULL,'DH10B'),('36',NULL,'NCI_CGAP_Br2','1st strand cDNA was prepared from pooled bulk brea','mammary gland, carcinoma, bulk, normalized, CGAP,',NULL,NULL,'7519','13440','895',NULL,'DH10B'),('37',NULL,'NCI_CGAP_Pr20','mRNA made from metastatic prostate lesion of the l','non-normalized, uncharacterized tissue, uncharacte',NULL,NULL,'166','384','923',NULL,'DH10B'),('39',NULL,'NCI_CGAP_Pr18','mRNA made from prostate BPH, stroma, cDNA made by','non-normalized, uncharacterized tissue, uncharacte',NULL,NULL,'677','1152','1055',NULL,'DH10B'),('41',NULL,'NCI_CGAP_Pr15','mRNA made from normal prostate epithelial cells, c','prostate, epithelium, normal, non-normalized, micr',NULL,NULL,'0','1152','1053',NULL,'DH10B'),('42',NULL,'NCI_CGAP_Pr16','mRNA made from invasive prostate tumor cells, cDNA','non-normalized, uncharacterized tissue, uncharacte',NULL,NULL,'644','1152','1054',NULL,'DH10B'),('45',NULL,'NCI_CGAP_GC3','1st strand cDNA was prepared from 3 pooled germ ce','germ cell, germ cell tumor, non-normalized, bulk,',NULL,NULL,'3228','11520','1049',NULL,'DH10B'),('46',NULL,'NCI_CGAP_GC4','1st strand cDNA was prepared from 3 pooled germ ce','germ cell, germ cell tumor, bulk, normalized, CGAP',NULL,NULL,'10166','16896','1050',NULL,'DH10B'),('48',NULL,'NCI_CGAP_Lei2','1st strand cDNA was primed with a Not I - oligo(dT','smooth muscle, leiomyosarcoma, bulk, normalized, C','Not I','Eco RI','3320','16896','1187',NULL,'DH10B'),('49',NULL,'NCI_CGAP_Kid3','1st strand cDNA was primed with a Not I - oligo(dT','kidney, normal, bulk, normalized, CGAP, EST, Soare','Not I','Eco RI','15681','25344','1045',NULL,'DH10B'),('50',NULL,'NCI_CGAP_Kid5','1st strand cDNA was primed with a Not I - oligo(dT','kidney, clear cell, renal cell carcinoma, bulk, no','Not I','Eco RI','14139','20352','1046',NULL,'DH10B'),('51',NULL,'NCI_CGAP_Co9','1st strand cDNA was prepared from RER+ colon tumor','carcinoma, non-normalized, colon, bulk, CGAP, EST,',NULL,NULL,'3802','6144','987',NULL,'DH10B'),('52',NULL,'NCI_CGAP_Co10','1st strand cDNA was prepared from RER+ colon tumor','carcinoma, colon, bulk, normalized, CGAP, EST, Soa',NULL,NULL,'4170','8832','956',NULL,'DH10B'),('53',NULL,'NCI_CGAP_Lu5','1st strand cDNA was prepared from neuroendocrine l','lung, neuroendocrine, carcinoma, bulk, normalized,',NULL,NULL,'20900','28800','1076',NULL,'DH10B'),('54',NULL,'NCI_CGAP_Co8','1st strand cDNA was prepared from colon adenocarci','adenocarcinoma, colon, bulk, normalized, CGAP, EST',NULL,NULL,'10262','13824','1079',NULL,'DH10B'),('55',NULL,'NCI_CGAP_GCB1','1st strand cDNA was prepared from human tonsillar','lymph node, B-cell, normal, flow-sorted, normalize','Not I','Eco RI','52246','73340','595',NULL,'DH10B'),('56',NULL,'NCI_CGAP_Br3','Cloned unidirectionally.  Primer: Oligo dT. Ductal','mammary gland, ductal, invasive, poorly differenti','EcoRI','XhoI','1017','1920','986',NULL,'SOLR (kanamycin resistant)'),('57',NULL,'NCI_CGAP_Gas1','Cloned unidirectionally.  Primer: Oligo dT. Pooled','stomach, neoplasia, non-normalized, bulk, CGAP, ES','EcoRI','XhoI','853','1152','989',NULL,'SOLR (kanamycin resistant)'),('58',NULL,'NCI_CGAP_Co11','Cloned unidirectionally.  Primer: Oligo dT. Multip','adenocarcinoma, non-normalized, colon, bulk, CGAP,','EcoRI','XhoI','1295','2304','938',NULL,'SOLR (kanamycin resistant)'),('59',NULL,'NCI_CGAP_GC5','Cloned unidirectionally.  Primer: Oligo dT. Mixed','germ cell, germ cell tumor, non-normalized, bulk,','EcoRI','XhoI','1191','1536','990',NULL,'SOLR (kanamycin resistant)'),('60',NULL,'NCI_CGAP_Pr23','Cloned unidirectionally.  Primer: Oligo dT. Pooled','prostate, adenocarcinoma, non-normalized, bulk, CG','EcoRI','XhoI','1015','1536','994',NULL,'SOLR (kanamycin resistant)'),('61',NULL,'NCI_CGAP_PI1','Cloned unidirectionally.  Primer: Oligo dT. Pooled','pancreatic islet, neuroendocrine, carcinoma, non-n','EcoRI','XhoI','0','768','932',NULL,'SOLR (kanamycin resistant)'),('62',NULL,'NCI_CGAP_SS1','Cloned unidirectionally.  Primer: Oligo dT. Synovi','soft tissue, synovial sarcoma, non-normalized, bul','EcoRI','XhoI','720','3072','995',NULL,'SOLR (kanamycin resistant)'),('63',NULL,'NCI_CGAP_Phe1','Cloned unidirectionally.  Primer: Oligo dT. Pheoch','adrenal medulla, pheochromocytoma, non-normalized,','EcoRI','XhoI','1356','2304','993',NULL,'SOLR (kanamycin resistant)'),('64',NULL,'NCI_CGAP_Lar1','Cloned unidirectionally.  Primer: Oligo dT. Larynx','larynx, squamous cell carcinoma, non-normalized, b','EcoRI','XhoI','1096','1536','992',NULL,'SOLR (kanamycin resistant)'),('65',NULL,'NCI_CGAP_Pr4.1','mRNA made from prostatic intraepithelial neoplasia','prostate, high grade, preneoplasia, non-normalized',NULL,NULL,'1283','3456','935',NULL,'DH10B'),('66',NULL,'NCI_CGAP_Co12','Cloned unidirectionally.  Primer: Oligo dT. Pooled','adenocarcinoma, non-normalized, colon, bulk, CGAP,','EcoRI','XhoI','2801','8448','988',NULL,'SOLR (kanamycin resistant)'),('67',NULL,'NCI_CGAP_Kid6','Cloned unidirectionally.  Primer: Oligo dT. Pooled','kidney, carcinoma, non-normalized, bulk, CGAP, EST','EcoRI','XhoI','6272','9600','991',NULL,'SOLR (kanamycin resistant)'),('68',NULL,'NCI_CGAP_HSC1','mRNA made from flow-sorted CD34+/CD38- hematopoiet','bone marrow, normal, non-normalized, flow-sorted,',NULL,NULL,'824','2304','933',NULL,'DH10B'),('69',NULL,'NCI_CGAP_Lym3','Cloned unidirectionally.  Primer: Oligo dT. Pooled','lymph node, lymphoma, non-normalized, bulk, CGAP,','EcoRI','XhoI','654','1152','1015',NULL,'SOLR (kanamycin resistant)'),('70',NULL,'NCI_CGAP_Br4','mRNA made from normal breast ductal tissue, cDNA m','non-normalized, uncharacterized tissue, uncharacte',NULL,NULL,'780','1920','1025',NULL,'DH10B'),('71',NULL,'NCI_CGAP_Br5','mRNA made from infiltrating ductal carcinoma, cDNA','non-normalized, uncharacterized tissue, uncharacte',NULL,NULL,'563','1920','1048',NULL,'DH10B'),('72',NULL,'NCI_CGAP_Ov5','mRNA made from normal ovarian epithelium, cDNA mad','non-normalized, uncharacterized tissue, uncharacte',NULL,NULL,'169','1152','1024',NULL,'DH10B'),('73',NULL,'NCI_CGAP_Ov6','mRNA made from normal ovarian cortical stroma, cDN','non-normalized, uncharacterized tissue, uncharacte',NULL,NULL,'157','1536','1008',NULL,'DH10B'),('74',NULL,'NCI_CGAP_Pr24','Cloned unidirectionally.  Primer: Oligo dT. Invasi','prostate, invasive, adenocarcinoma, non-normalized','EcoRI','XhoI','995','1536','1016',NULL,'SOLR (kanamycin resistant)'),('75',NULL,'NCI_CGAP_Pr25','Cloned unidirectionally.  Primer: Oligo dT. Normal','prostate, normal, non-normalized, cell line, CGAP,','EcoRI','XhoI','1883','3456','1017',NULL,'SOLR (kanamycin resistant)'),('76',NULL,'NCI_CGAP_Kid7','Cloned unidirectionally.  Primer: Oligo dT. Pooled','kidney, carcinoma, non-normalized, bulk, CGAP, EST','EcoRI','XhoI','0','1920','1047',NULL,'SOLR (kanamycin resistant)'),('77',NULL,'NCI_CGAP_Thym1','Cloned unidirectionally.  Primer: Oligo dT. Thymom','thymus, thymoma, non-normalized, bulk, CGAP, EST,','EcoRI','XhoI','0','1152','1052',NULL,'SOLR (kanamycin resistant)'),('78',NULL,'NCI_CGAP_CLL1','1st strand cDNA was primed with a Not I - oligo(dT','white blood cell, chronic lymphocytic leukemia, fl','Not I','Eco RI','13690','22272','1317',NULL,'DH10B'),('79',NULL,'NCI_CGAP_GCB0','Cloned unidirectionally.  Primer: Oligo dT. Germin','lymph node, B-cell, normal, non-normalized, flow-s','EcoRI','XhoI','907','3456','1051',NULL,'SOLR (kanamycin resistant)'),('80',NULL,'NCI_CGAP_CNS1','Cloned unidirectionally.  Primer: Oligo dT.  Avera','brain, normal, non-normalized, substantia nigra, b','SalI','NotI','435','2304','1080',NULL,'DH10B'),('1595',NULL,'Barstead colon HPLRB7','1st strand cDNA was primed with a Not I - oligo(dT','normal, non-normalized, colon, bulk, adult, EST','EcoRI','NotI','6579',NULL,'1556',NULL,'DH10B (phage resistant)'),('17904',NULL,'NIH_MGC_76','5\' and 3\' adaptors were used in cloning as follows','liver, normal, non-normalized, bulk, EST, MGC, Clo','SfiI (ggccgcctcggcc)','SfiI (ggccattatggcc)','11960','13440','6989',NULL,'DH10B (T1 phage-resistant)'),('18970',NULL,'GLC',NULL,'liver, normal, bulk, adult, EST','EcoRI','XhoI','19237',NULL,'5601',NULL,'SOLR'),('19904',NULL,'GKC',NULL,'liver, carcinoma, bulk, adult, EST','EcoRI','XhoI','17732',NULL,'6533',NULL,'SOLR'),('22020',NULL,'Athersys RAGE Library','See \'Creation of Genome-wide Protein Expression Li','uncharacterized tissue, uncharacterized histology,',NULL,NULL,'43475',NULL,'8655',NULL,NULL),('27590',NULL,'NCI_CGAP_FG1','NCI_CGAP_FG1 is a normalized cDNA LIBRARY obtained','bone, cell line, normalized, CGAP, EST, Soares nor','EcoR I','Not I','3810','4992','11914',NULL,'DH10B (Life Technologies)'),('29975',NULL,'L17N670205n1','The LIBRARY was contributed by the Soares laborato','liver, normal, cell line, normalized, EST','EcoRI','NotI','3784',NULL,'12542',NULL,'Top10F\''),('37954',NULL,'Full Length cDNA from the Mammalian Gene Collectio','The ORFs were PCR amplified from the MGC (Mammalia','EST',NULL,NULL,'8076',NULL,'16264',NULL,NULL),('38088',NULL,'Sugano cDNA LIBRARY, small intestine',NULL,'EST',NULL,NULL,'5568',NULL,'16400',NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `LIBRARY` ENABLE KEYS */;

--
-- Table structure for table `LIBRARY_GENE`
--

DROP TABLE IF EXISTS `LIBRARY_GENE`;
CREATE TABLE `LIBRARY_GENE` (
  `GENE_ID` decimal(10,0) NOT NULL default '0',
  `LIBRARY_ID` decimal(10,0) NOT NULL default '0',
  PRIMARY KEY  (`GENE_ID`,`LIBRARY_ID`),
  KEY `idx_GENE_ID` (`GENE_ID`),
  KEY `idx_LIBRARY_ID` (`LIBRARY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `LIBRARY_GENE`
--


/*!40000 ALTER TABLE `LIBRARY_GENE` DISABLE KEYS */;
LOCK TABLES `LIBRARY_GENE` WRITE;
INSERT INTO `LIBRARY_GENE` VALUES ('2','54'),('2','1595'),('2','17904'),('2','18970'),('2','19904'),('2','22020'),('2','27590'),('2','29975'),('2','37954'),('2','38088'),('3','14'),('3','25'),('3','36'),('3','42'),('3','48'),('3','49'),('3','50'),('3','1595'),('3','17904'),('3','18970'),('3','19904'),('3','22020'),('3','29975'),('3','38088'),('5','1595'),('6','37954'),('7','37954'),('9','26'),('9','22020'),('10','21'),('10','36'),('10','46'),('10','49'),('10','50'),('10','53'),('10','54'),('10','55'),('10','78'),('10','17904'),('10','22020'),('10','27590'),('10','37954'),('10','38088'),('11','49'),('12','36'),('12','53'),('12','55'),('12','79'),('12','19904'),('12','37954'),('13','8'),('13','48'),('13','52'),('13','55'),('13','74'),('13','78'),('14','18970'),('14','22020'),('14','29975'),('14','38088'),('15','15'),('15','22'),('15','45'),('15','46'),('15','49'),('15','53'),('15','54'),('15','55'),('15','78'),('15','18970'),('16','18970'),('17','15'),('17','49'),('17','51'),('17','52'),('17','37954'),('18','28'),('18','37954'),('19','50'),('20','1'),('20','2'),('20','12'),('20','14'),('20','15'),('20','16'),('20','36'),('20','45'),('20','46'),('20','48'),('20','49'),('20','50'),('20','52'),('20','53'),('20','54'),('20','55'),('20','56'),('20','67'),('20','1595'),('20','17904'),('20','18970'),('20','19904'),('20','22020'),('20','29975'),('20','38088'),('22','15'),('22','19'),('22','31'),('22','46'),('22','48'),('22','50'),('22','52'),('22','54'),('22','18970'),('22','19904'),('22','29975'),('22','37954'),('23','36'),('23','53'),('24','12'),('24','15'),('24','33'),('24','34'),('24','36'),('24','45'),('24','49'),('24','50'),('24','53'),('24','54'),('24','55'),('24','60'),('24','64'),('24','67'),('24','69'),('24','75'),('24','78'),('24','1595'),('24','27590'),('24','37954'),('25','37954'),('27','36'),('27','46'),('27','48'),('27','54'),('27','55'),('27','59'),('27','64'),('27','67'),('27','78'),('27','29975'),('27','37954'),('28','55'),('28','17904'),('29','51'),('29','66'),('29','17904'),('29','18970'),('29','38088'),('30','31'),('30','36'),('30','46'),('30','49'),('30','53'),('30','54'),('30','22020'),('30','27590'),('32','45'),('32','50'),('32','55'),('32','78'),('32','22020'),('32','37954'),('33','55'),('33','37954'),('34','9'),('34','26'),('34','29'),('34','36'),('34','46'),('34','49'),('34','52'),('34','53'),('34','68'),('34','19904'),('34','22020'),('34','27590'),('34','37954'),('35','15'),('35','52'),('35','54'),('35','1595'),('36','15'),('36','54'),('36','55'),('36','67'),('36','74'),('36','78'),('36','37954'),('37','15'),('37','36'),('37','45'),('37','48'),('37','50'),('37','54'),('37','37954'),('38','37954'),('39','67'),('40','49'),('41','7'),('41','12'),('41','15'),('41','34'),('41','35'),('41','50'),('41','53'),('41','55'),('41','70'),('41','78'),('41','1595'),('41','19904'),('41','37954'),('44','34'),('47','15'),('47','37954'),('48','49'),('48','50'),('48','78'),('49','15'),('49','22'),('49','23'),('49','27'),('49','30'),('49','31'),('49','33'),('49','34'),('49','35'),('49','46'),('49','48'),('49','49'),('49','50'),('49','53'),('49','54'),('49','56'),('49','58'),('49','66'),('49','67'),('49','69'),('49','1595'),('49','27590'),('50','78'),('53','55'),('54','1'),('54','2'),('54','15'),('54','29'),('54','36'),('54','48'),('54','49'),('54','51'),('54','53'),('54','78'),('54','1595'),('54','18970'),('54','37954'),('55','18970'),('56','3'),('56','15'),('56','36'),('56','46'),('56','55'),('56','78'),('56','18970'),('56','19904'),('56','37954'),('57','37954'),('59','50'),('59','53'),('59','54'),('59','55'),('59','66'),('59','18970'),('59','27590'),('59','37954'),('60','31'),('61','51'),('61','78'),('62','52'),('62','54'),('62','66'),('62','78'),('62','18970'),('62','19904'),('63','78'),('63','37954'),('65','34'),('65','38088'),('67','15'),('67','29'),('67','36'),('67','55'),('67','22020'),('67','37954'),('68','54'),('68','38088'),('70','9'),('70','15'),('70','17'),('70','27'),('70','28'),('70','33'),('70','35'),('70','36'),('70','49'),('70','50'),('70','53'),('70','54'),('70','58'),('70','66'),('70','1595'),('70','22020'),('70','37954'),('70','38088'),('72','2'),('72','11'),('72','14'),('72','15'),('72','32'),('72','33'),('72','34'),('72','46'),('72','49'),('72','50'),('72','52'),('72','53'),('72','55'),('72','62'),('72','64'),('72','1595'),('72','17904'),('74','51'),('74','55'),('74','17904'),('74','18970'),('76','34'),('76','52'),('76','56'),('76','78'),('76','37954'),('77','50'),('78','33'),('78','36'),('78','46'),('78','49'),('78','50'),('78','54'),('78','55'),('78','56'),('78','17904'),('78','22020'),('78','29975'),('79','36'),('79','49'),('79','52'),('79','78'),('79','37954'),('80','37954'),('81','49'),('82','22020'),('83','78'),('83','38088'),('84','15'),('84','34'),('84','50'),('84','51'),('84','52'),('84','54'),('84','1595'),('84','37954'),('85','31'),('85','55'),('85','17904'),('85','19904'),('85','37954'),('86','1'),('86','15'),('86','36'),('86','46'),('86','49'),('86','51'),('86','53'),('86','75'),('87','9'),('87','12'),('87','15'),('87','28'),('87','30'),('87','36'),('87','45'),('87','46'),('87','49'),('87','50'),('87','51'),('87','52'),('87','53'),('87','54'),('87','55'),('87','58'),('87','59'),('87','60'),('87','66'),('87','78'),('87','17904'),('87','19904'),('87','37954'),('87','38088'),('88','15'),('88','49'),('88','52'),('88','78'),('89','1'),('89','9'),('89','12'),('89','15'),('89','36'),('89','45'),('89','46'),('89','49'),('89','50'),('89','52'),('89','27590'),('89','37954'),('90','56'),('90','37954'),('90','38088'),('93','50'),('93','53'),('93','66'),('93','22020'),('93','37954'),('95','15'),('95','22020'),('95','37954'),('96','50'),('97','15'),('97','22'),('97','35'),('97','46'),('97','49'),('97','53'),('97','54'),('97','78'),('97','27590'),('98','3'),('98','22'),('98','23'),('98','29'),('98','33'),('98','34'),('98','49'),('98','50'),('98','51'),('98','53'),('98','54'),('98','55'),('98','18970'),('98','19904'),('98','29975'),('98','37954'),('98','38088'),('99','15'),('100','37954'),('101','30'),('101','46'),('101','51'),('101','53'),('101','55'),('101','17904'),('101','29975'),('102','2'),('102','50'),('102','54'),('102','55'),('102','78'),('102','1595'),('103','2'),('103','34'),('103','53'),('103','55'),('103','78'),('103','37954'),('104','36'),('104','46'),('104','52'),('104','55'),('104','78'),('104','22020'),('104','37954'),('105','34'),('105','67'),('107','30'),('108','30'),('109','49'),('110','22020'),('111','12'),('111','15'),('111','18'),('111','25'),('111','46'),('111','49'),('111','50'),('111','53'),('111','54'),('111','55'),('111','62'),('111','66'),('111','67'),('111','18970'),('111','19904'),('111','29975'),('111','37954'),('112','29975'),('114','22020'),('115','14'),('115','78'),('116','1'),('116','53'),('116','55'),('117','26'),('117','18970'),('117','29975'),('118','53'),('118','66'),('118','17904'),('118','18970'),('118','19904'),('118','29975'),('119','49'),('119','37954');
UNLOCK TABLES;
/*!40000 ALTER TABLE `LIBRARY_GENE` ENABLE KEYS */;

--
-- Table structure for table `SEQUENCE`
--

DROP TABLE IF EXISTS `SEQUENCE`;
CREATE TABLE `SEQUENCE` (
  `SEQUENCE_ID` decimal(10,0) NOT NULL default '0',
  `ACCESSION_NUMBER` varchar(50) default NULL,
  `IS_REF_SEQUENCE` tinyint(1) NOT NULL default '0',
  `DESCRIPTION` varchar(4) default NULL,
  `ASCII_STRING` text,
  `LENGTH` decimal(10,0) default NULL,
  `SEQUENCE_TYPE` decimal(10,0) default NULL,
  `VERSION` varchar(10) default NULL,
  `CLONE_ID` decimal(10,0) default NULL,
  PRIMARY KEY  (`SEQUENCE_ID`),
  KEY `idx_CLONE_ID` (`CLONE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SEQUENCE`
--


/*!40000 ALTER TABLE `SEQUENCE` DISABLE KEYS */;
LOCK TABLES `SEQUENCE` WRITE;
INSERT INTO `SEQUENCE` VALUES ('2','BG617259',0,NULL,'tgatcatatagggcctcctctctatagccgaacgacgagcgcagcgagtcattgagcgaggaagcggcgcataacttcgtatagcatacattatacgaagttatcagtcgacggtaccggacatatgcccgggaattcggccattacggccGGGATTTACGCTTGAACCTCAAACAATTGAAGATTTTGAGTCTATGAATACATACCTGCAGACGTCTCCAACATCTTCATTTATAACCACATCATTTTGTTCCTTGCAGACCCCAGAAGGGGTTTACTGTTTGGTGGGCTTCATCCTCACCTATAGAAAATtcaattataaagacaatacagatctggtcgagtTTAAAACTCTCACTGAGGAAGAGGTTGAAGAAGTGCTGAAAAATATATTTAAGATTTCCTTGGGGAGAAATCTCGTGCCCAAACCTGGTGATGGATCCCTTACTATTTAGAATAAGGAACAAAATAAACCCTTGTGTATGTATCACCCAACTCACTAATTATCAACTTATGTGCTATCAGATATCCTCTCTACCCTCACGTTATTTTGAAGAAAATCCTAAACATCAAATACTTTCATCCATAAAAATGTCAGCATTTATTAAAAAACAATAACTTtttaaagaaacataaggacacattttcaaattaataaaaataaaggcattttaaggatgGCCTGTGATTATCTTGGGAAGCAGAGTGATTCATGCTAGAAAACATTTAATATTGATTTATTGTTGAATTCATAGTAAATTTTTACTGGTAAATGAATAAGAATAT','786','1','1','2'),('3','CV029049',0,NULL,'ATGGACATTGAAGCATATTTTGAAAGAATTGGCTATAAGAACTCTAGGAACAAATTGGACTTGGAAACATTAACTGACATTCTTGAGCACCAGATCCGGGCTGTTCCCTTTGAGAACCTTAACATGCATTGTGGGCAAGCCATGGAGTTGGGCTTAGAGGCTATTTTTGATCACATTGTAAGAAGAAACCGGGGTGGGTGGTGTCTCCAGGTCAATCAACTTCTGTACTGGGCTCTGACCACAATCGGTTTTCAGACCACAATGTTAGGAGGGTATTTTTATATCCCTCCAGTTAACAAATACAGCACTGGCATGGTTCACCTTCTCCTGCAGGTGACCATTGACGGCAGGAATTACATTGTCGATGCTGGGTCTGGAAGCTCCTCCCAGATGTGGCAGCCTCTAGAATTAATTTCTGGGAAGGATCAGCCTCAGGtgccttgcattttctgcttgacagaagagagaggaaTCTGGTACCTGGACCAAATCAGGAGAGAGCAGTATATTACAAACAAAGAATTTCTTAATTCTCATCTCCTGCCAAAGAAGAGACACCAAAAAATATACTTANTTACGCTTGAACCTCAACAATTGAAGAATTTGAGTCTATGAATACATACCT','625','1','1','3'),('4','BG618195',0,NULL,'ccgacgagcgcagcgaagtcagttgagcgaggaagcggccgcataacttcgtatagcatacattatacgaagttatcagtcgacggtaccggacatatgcccgggaattcggccattacggccGGGGACTTTATTACAGACCTTGGAAGCAAGAGGATGCATTCAGCCTAGTTCCTGGTTGCTGGCCAAAGGGATCATGGACATTGAAGCATATTTTGAAAGAATTGGCTATAAGAACTCTAGGAACAAANTGGACTTGGAAACATTAACTGACATTCTTGAGCACCAGATCCGGGCTGTTCCCTTTGAGAACCTTAACATGCATTGTGGGCAAGCCATGGAGTTGGGCTTAGAGGCTATTTTTGATCACATTGTAAGAAGAAACCGGGGTGGGTGGTGTCTCCAGGTCAATCAACTTCTGTACTGGGCTCTGACCACAATCGGTTTTCAGACCACAATGTTAGGAGGGTATTTTTACATCCCTCCAGTTAACAAATACAGCACTGGCATGGTTCACCTTCTCCTGCAGGTGACCACTGACGGCAGGAATTACATTGTCGATGCTGGGTCTGGAAGCTCCTCCCAGATGTGGCAGCCTCTAGAATTAATTTCTGGGAAGGATCAGCCTCAGGtgccttgcattttctgcttgacagaagagagaggaaTCTGGTACTTGGACCAAATCAGGAGAGAGCAGTATATTACAAACAAAGAATTTCTTAATTCTCATCTCCTGCCAAAGAAGAAACAGCAAAAAATATACTTATTTACGCTTGAACCTCGAACAATTGAAGAATTCCGAGTCTATGAATACATACCTGCAGACGTCTCCAAAATCTTCATTTATAACCACATCATTTTGTTCCTTGCAGAACCCAAGAAGG','887','1','1','4'),('5','AV658656',0,NULL,'CACTTTATTACAGACCTTGGAAGCAAGAGGATTGCATTCAGCCTAGTTCCTGGTTGCTGGCCAAAGGGATCATGGACATTGAAGCATATTTTGAAAGAATTGGCTATAAGAACTCTAGGAACAAATTGGACTTGGAAACATTAACTGACATTCTTGAGCACCAGATCCGGGCTGTTCCCTTTGAGAACCTTAACATGCATTGTGGGCAAGCCATGGAGTTGGGCTTAGAGGCTATTTTTGATCACATTGTAAGAAGAAACCGGGGTGGGTGGTGTCTCCAGGTCAATCAACTTCTGTACTGGGCTCTGACCACAATCGGTTTTCAGACCACAATGTTAGGAGGGTATTTTTACATCCCTCCAGTTAACAAATACAGCACTGGCATGGTTCACCTTCTCCTGCAGGTGACC','410','1','1','5'),('7','AI733799',0,NULL,'TTTTCCACAATATTCTTTATTCATTTACCAGTAAAAATTTACTATGAATTCAACAATAAATCAATATTAAATGTTTTCTAGCATGAATCACTCTGCTTCCCAAGATAATCACAGGCcatccttaaaatgcctttatttttattaatttgaaaatgtgtccttatgtttctttaaaaagttattgttttttaATAAATGCTGACATTTTTATGGATGAAAGTATTTGATGTTTAGGATTTTCTTCAAAATAACGTGAGGGTAGAGAGGATATCTGATAGCACATAAGTTGATAATTAGTGAGTTGGGTGATACATACACAAGGGTTTATTTTGTTCCTTATTCTAAATAGTAAGGGATCCATCACCAGGTTTGGGCACGAGATTTCTCCCCAAGGAAATCTTAAATATATTTTTCAGCACTTCTTCAACCTCTTCCTCAGTGAGAGTTTTAAactcgaccagatctgtattgtctttataattgaATTTTCTATAGGTGAGGATGAAGCCCACCAAACAGTAAACCCCTTCTGGGGTCTGCAAGGAACAAAATGATGTGGTTATAAATGAAGATGTTGGAGACGTCTGCAGGTATGTATTCATAGACTCAAAATCTTCAATTGTTCGAGGTTCAAGCGTAAATAAGTATATTTTTTCGGTGTTCTTTCTTCGGCAGGAGATGAGAATTAAGAACATTCTTTGTTGGGAATATACTGCTCTC','720','1','1','6'),('8','AV684197',0,NULL,'GCACTCTATTACAGACCTTGTAAGCACGAGGATTGCATTCAGCCTAGTTCCTGGGTGCTGTCCAAAGGGATCATGGACATTGAAGCATATTTTGAAAGAATTGGCTATAAGAACTCTAGGAACAAATTGGACTTGGAAACATTAACTGACATTCTTGAGCACCAGATCCGGGCTGTTCCCTTTGAGAACCTTAACATGCATTGTGGGCAAGCCATGGAGTTGGGCTTAGAGGCTATTTTTGATCACATTGTAAGAAGAAACCGCGGTGGGTGGTGTCTTCAGGTCAATCAACTTCTGTACTGGGCTCTGACCACAATCGGGTTTCAGACCACAATGTTAGGAGGGTATTTTTATATCCCTCCAGGTCTACAGCACTGGCATGGGTCACCTTCTTCTGCAGGTGACCTN','408','1','1','7'),('9','BG569272',0,NULL,'ttgtatagactcactatagggcgctagctcggttgcagccgaacgaccgagcgcagcgagtcagtgagcgaggaagcggccgcataacttcgtatagcatacattatacgaagttatcagtcgacggtaccggacatatgcccgggaattcggccattacggccGGGGATTACAGACCTTGGAAGCAAGAGGATTGCATTCAGCCTAGTTCCTGGTTGCTGGCCAAAGTGACCACTGACGGCAGGAATTACATTGTCGATGCTGGGTCTGGAAGCTCCTCCCAGATGTGGCAGCCTCTAGAATTAATTTCTGGGAAGGATCAGCCTCAGGtgccttgcattttctgcttgacagaagagagaggaaTCTGGTACTTGGACCAAATCAGGAGAGAGCAGTATATTACAAACAAAGAATTTCTTAATTCTCATCTCCTGCCAAAGAAGAAACACCAAAAAATATACTTATTTACGCTTGAACCTCGAACAATTGAAGATTTTGAGTCTATGAATACATACCTGCAGACGTCTCCAACATCTTCATTTATAACCACATCATTTTGTTCCTTGCAGACCCCAGAAGGGGTTTACTGTTTGGTGGGCTTCATCCTCACCTATAGAAAATtcaattataaagacaatacagatctggtcgagtTTAAAACTCTCACTGAGGAAGAGGTTGAAGAAGTGCTGAGAAATATATTTAAGATTTCCTTGGGGAGAAATCTCGTGCCCAAACCTGGTGATGGATCCCTTACTATTTAGAATAAGGAACAAAATAAACCCTTGTGTATGTATCACCCAACTCACTAATTATCAAGTTATGTGCTATCAGATATCCTCTCTAGCCTCACGTTATTTCGAAGAAAATCCTAAACATCA','884','1','1','8'),('11','AI460128',0,NULL,'CCACAATATTCTTTATTCATTTACCAGTAAAAATTTACTATGAATTCAACAATAAATCAATATTAAATGTTTTCTAGCATGAATCACTCTGCTTCCCAAGATAATCACAGGCcatccttaaaatgcctttatttttattaatttgaaaatgtgtccttatgtttctttaaaaagttattgttttttaataaaTGCTGACATTTTTATGGATGAAAGTATTTGATGTTTAGGATTTTCTTCAAAATAACGTGAGGGTAGAGAGGATATCTGATAGCACATAAGTTGATAATTAGTGAGTTGGGTGATACATACACAAGGGTTTATTTTGTTCCTTATTCTAAATAGTAAGGGATCCATCACCAGGTTTGGGCACGAGATTTCTCCCCAAGGAAATCTTAAATATATTTCTCAGCACTTCTTCAACCTCTTCCTCAGTGAGAGTTTTAAactcgaccagatctgtattgtctttataattgaATTTTCTATAGGTGAGGATGAAGCCCACCAAACAGTAAACCCCTTTCTGGGTCTGCAAGGA','541','1','1','9'),('12','BP262787',0,NULL,'ACTTTATTACAGACCTTGGAAGCAAGAGGATTGCATTCAGCCTAGTTCCTGGTTGCTGGCCAAAGGGATCATGGACATTGAAGCATATTTTGAAAGAATTGGCTATAAGAACTCTAGGAACAAATTGGACTTGGAAACATTAACTGACATTCTTGAGCACCAGATCCGGGCTGTTCCCTTTGAGAACCTTAACATGCATTGTGGGCAAGCCATGGAGTTGGGCTTAGAGGCTATTTTTGATCACATTGTAAGAAGAAACCGGGGTGGGTGGTGTCTCCAGGTCAATCAACTTCTGTACTGGGCTCTGACCACAATCGGTTTTCAGACCACAATGTTAGGAGGGTATTTTTACATCCCTCCAGTTAACAAATACAGCACTGGCATGGTTCACCTTCTCCTGCAGGTGACCATTGACGGCAGGAATTACATTGTCGATGCTGGGTCTGGAAGCTCCTCCCAGATGTGGCAGCCTCTAGAATTAATTTCTGGGAAGGATCAGCCTCAGGtgccttgcattttctgcttgacagaagagagaggaaTCTGGTACCTGGACCAAATCAGGAGAGAGCAGTATATTA','581','1','1','10'),('13','BG563731',0,NULL,'AAAAATGTAGATCATATAGGGGCTAGCTCGTGCAAGCGAACGACGAGCGCAGCGAAGTAGTGAGCGAGGAAgcggccgcataacttcgtatagcatacattatacgaagttatcagtcgacggtaccggacatatgcccgggaattcggccattacggccGGGGACTTTATTACAGACCTGGAAGCAAGAGGATGCATTCAGCCTAGTTCCTGGTTGCTGGCCAAAGGGATCATGGACATTGAAGCATATTTTGAAAGAATTGGCTATAAGAACTCTAGGAACAAATTGGACTTGGAAACATTAACTGACATTCTTGAGCACCAGATCCGGGCTGTTCCCTTTGAGAACCTTAACATGCATTGTGGGCAAGCCATGGAGTTGGGCTTAGAGGCTATTTTTGATCACATTGTAAGAAGAAACCGGGGTGGGTGGTGTCTCCAGGTCAATCAACTTCTGTACTGGGCTCTGACCACAATCGGTTTTCAGACCACAATGTTAGGAGGGTATTTTTATATCCCTCCAGTTAACAAATACAGCACTGGCATGGTTCACCTTCTCCTGCAGGTGACCATTGACGGCAGGAATTACATTGTCGATGCTGGGTCTGGAAAGCTCCTCCCAGATGTGGCAGCCTCTAGAATTAATTTCTGGGAAGGATCAGCCTCAGGtgccttgcattttctgcttgacagaagagagaggaaTCTGGTACCTGGACCAAATCAGGAGAGAGCAGTATATTACAAACAAAGAATTTCTTAATTCTCATCTCCTGGCCAAAGAAGAAACACCAAAAAATATACTTATTTACGCTTGAACCTCAAACAATTGAAGATTTGAGTCTATGAATACATACCTGCAGACGTCTCCCAAATCTTCATTTATTACCACATAT','896','1','1','11'),('14','BG568400',0,NULL,'AAAATTTGACATCACTATAGGGCGCTAGCTCGGTCTGTAGCCGAACGAACCGAGCGCAGCGAGTAGTGAGCGAGGAAgcggccgcataacttcgtatagcatacattatacgaagttatcagtcgacggtaccggacatatgcccgggaattcggccattacggccGGGGACTTTATTACAGACCTTGGAAGCAAGAGGATTGCATTCAGCCTAGTTCCTGGTTGCTGGCCAACAGGGATCATGGACATTGAAGCATATTTTGAAAGAATTGGCTATAAGAACTCTAGGAACAAATTGGACTTGGAAACATTAACGTGACATTCTTGAGCACCAGATCCGGGCTGTTCCCTTTGAGAACCTTAACATGCATTGTGGGCAAGCCATGGAGTTGGGCTTAGAGGCTATTTTTGATCACATTGTAAGAAGAAACCGGGGTGGGTGGTGTCTCCAGGTCAATCAACTTCTGTACTGGGCTCTGACCACAATCGGTTTTCAGACCACAATGTTAGGAGGGTATTTTTATATCCCTCCAGTTAACAAATACAGCACTGGCATGGTTCAGCTTCTCCTGCAGGTGACCATTGACGGCATGGAATTACATTGTCAGATGCTGGGTCTGGAAGCTCCTCCCAGATGTGGCAGCCTCTAGAATTAATTTCTGGGAAGGATCAGCCTCAGGTGCCTTGCATATTCTGCTTGACAGAAGAGAGAGGAATCTGGTACCTGGACCAAATCAGGAGAGAGCAGTATATTACAAACAAAGAATTTTCTTAATTCTCATCTCCTGCCAAAGAAGAAACACCAAAAAATATACTTATTTACGCTTGAACCTCAAACAATTGACGATTTGAGTCTATGAATACATACCTGCAGACGTCTCCAACATCTTCATTTATAACCACATCATATTGTTCCTTGCAGACCCCAGAAGGGGTA','937','1','1','12'),('15','BG566307',0,NULL,'agacttgtatagactcactatagggcgctagctcgttagagcgaacgaccgagcgcagcgacgtagtgagcgaggaagcggccgcataacttcgtatagcatacattatacgaagttatcagtcgacggtaccggacatatgcccgggaattcggccattacggccGGGGGGGTGGGTGGTGTCTCCAGGTCAATCAACTTCTGTACTGGGCTCTGACCACAATCGGTTTTCAGACCACAATGTTAGGAGGGTATTTTTATATCCCTCCAGTTAACAAATACAGCACTGGCATGGTTCACCTTCTCCTGCAGGTGACCATTGACGGCAGGAATTACATTGTCGATGCTGGGTCTGGAAGCTCCTCCCAGATGTGGCAGCCTCTAGAATTAATTTCTGGGAAGGATCAGCCTCAGGtgccttgcattttctgcttgacagaagagagaggaaTCTGGTACCTGGACCAAATCAGGAGAGAGCAGTATATTACAAACAAAGAATTTCTTAATTCTCATCTCCTGCCAAAGAAGAAACACCAAAAAATATACTTATTTACGCTTGAACCTCAAACAATTGAAGATTTTGAGTCTATGAATACATACCTGCAGACGTCTCCAACATCTTCATTTATAACCACATCATTTTGTTCCTTGCAGACCCCAGAAGGGGTTTACTGTTTGGTGGGcttcatccttcacctatagaacattcaattataaagacaatacagatctggtcgagtTTAAAACTCTCACTGAGGAAGCAGGTTGCAAGAAGTGCTGAAACACATATCTTTAACGATTTCCTTGGGGCAGAAATCTCGTGCCCAAACTGGTGATGGATCCCTTAACTATTCAAAAATTCGGGCACCAAAATTAAAACGCTTGTAGTATGTTTTCACCGCAAATTCACTAATTTTTCAACTCTATGttgcttattcagaatatcctctttaccctcaacgtaattttgacgaacaaTCCTACAACTTCACATTCCTTCATCCACTCAAAATGTCCACCATTATG','1029','1','1','13'),('17','BG533459',0,NULL,'tatactaattgggcagcgcgctactgcgaacgacgagcgcagcgagtcagtgagcgaggaagcggccgcataacttcgtatagcatacattatacgaagttatcagtcgacggtaccggacatatgcccgggaattcggccattacggccGGGGACTTTATTACAGACCTGGAAGCAAGAGGATGCATTCAGCCTAGTTCCTGGTTGCTGGCCAAAGGGATCATGGACATGAAGCATATTTGAAAGAATGGCTATAAGAACTCTAGGAACAAATGGACTTGGAAACATTAACTGACATTCTTGAGCACCAGATCCGGGCTGTTCCCTTTGAGAACCTTAACATGCATGTGGGCAAGCCATGGAGTTGGGCTTAGAGGCTATTTTTGATCACATGTAAGAAGAAACCGGGGTGGGTGGTGTCTCCAGGTCAATCAACTTCTGTACTGGGCTCTGACCACAATCGGTTTTCAGACCACAATGTTAGGAGGGTATTTTTATATCCCTCCAGTTAACAAATACAGCACTGGCATGGTTCACCTTCTCCTGCAGGTGACCATTGACGGCAGGAATTACATTGTCGATGCTGGGTCTGGAAGCTCCTCCCAGATGTGGCAGCCTCTAGAATTAATTTCTGGGAAGGATCAGCCTCAGGtgcctgcattttctgcttgacagaagagagaggaaTCTGGTACCTGGACCAAATCAGGAGAGAGCAGTATATTACAAACAAAGAATTTCTTAATTCTCATCTCCTGGCCAAAGAAGAAACAANCAAAAAATATACTTATGTACGCTTGAACCTCAAAACAATTGAAGATTTGAGTCTATGAATACATACCTGCAGACGTCTCCAACATCTTCATTTATAACCACATCATTTGTTCCTTGGAGACCCCAGAAGGGGTTTACTGTTGGTGG','921','1','1','14'),('18','AV658623',0,NULL,'CACTTTATTACAGACCTTGGAAGCAAGAGGATTGCATTCAGCCTAGTTCCTGGTTGCTGGCCAAAGGGATCATGGACATTGAAGCATATTTTGAAAGAATTGGCTATAAGAACTCTAGGAACAAATTGGACTTGGAAACATTAACTGACATTCTTGAGCACCAGATCCGGGCTGTTCCCTTTGAGAACCTTAACATGCATTGTGGGCAAGCCATGGAGTTGGGCTTAGAGGCTATTTTTGATCACATTGTAAGAAGAAACCGGGGTGGGTGGTGTCTCCAGGTCAATCAACTTCTGTACTGGGCTCTGACCACAATCGGTTTTCAGACCACAATGTTAGGAGGGTATTTTTACATCCCTCCAGTTAACAAATACAGCACTGGCATGGTTCACCTTCTCCTGCAGGTGACCATTGACGGCAGGAATTACATTGT','433','1','1','15'),('19','CB161860',0,NULL,'GGAAGCAAGAGGATTGCATTCAGCCTAGTTCCTGGTTGCTGGCCAAAGGGATCATGGACATTGAAGCATATTTTGAAATAATTGGCTATAAGAACTCTAGGAACAAATTGGACTTGGAAACATTAACTGACATTCTTGAGCACCAGATCCGGGCTGTTCCCTTTGAGAACCTTAACATGCATTGTGGGCAAGCCATGGAGTTGGGCTTAGAGGCTATTTTTGATCACATTGTAAGAAGAAACCGGGGTGGGTGGTGTCTCCAGGTCAATCAACTTCTGTACTGGGCTCTGACCACAATCGGTTTTCAGACCACAATGTTAGGAGGGTATTTTTACATCCCTCCAGTTAACAAATACAGCACTGGCATGGTTCACCTTCTCCTGCAGGTGACCATTGACGGCAGGAATTACATTGTCGATGCTGGGTCTGGAAGCTCCTCCCAGATGTGGCAGCCTCTAGAATTAATTTCTGGGAAGGATCAGCCTCAGGtgccttgcattttctgcttgacagaagagagaggaaTCTGGTAC','533','1','1','16'),('20','BU624903',0,NULL,'agtgccaagctaaaattaaccctcactaaagggaataagcttgcggccgcCCGGTCACTCttttttttttttttttttttttttttCCACAATATTCTTTATTCATTTACCAGTAAAAATTTACTATGAATTCAACAATAAATCAATATTAAATGTTTTCTAGCATGAATCACTCTGCTTCCCAAGATAATCACAGGCcatccttaaaatgcctttatttttattaatttgaaaatgtgtccttatgtttctttaaaaagttattgttttttaaTAAATGCTGACATTTTTATGGATGAAAGTATTTGATGTTTAGGATTTTCTTCAAAATAACGTGAGGGTAGAGAGGATATCTGATAGCACATAAGTTGATAATTAGTGAGTTGGGTGATACATACACAAGGGTTTATTTTGTTCCTTATTCTAAATAGTAAGGGATCCATCACCAGGTTTGGGCACGAGATTTCTCCCCAAGGAAATCTTAAATATATTTTTCAGCACTTCTTCAACCTCTTCCTCAGTGAGAGTTTTAAactcgaccagatctgtattgtctttataattgaATTTTCTATAGGTGAGGATGAAGCCCACCAAACAGTAAACCCCTTCCTGGGGTCTGCAAGGAACAAAATGATGTGGTTATAAATGAAGATGTTGGAGACGTCTGCAGGTATGTATTCATAGACTCAAAATCTTCAATTGTTCGAGGTTCAAGCGTAAATAAGTATATTTTTTGGGTGTTTCTNTCTTTGGCAGGAGATGAGAATTAAGAATTCTTTGTTTGTAATATACTGCTCTCTCCTGATTTGGTCCAANGTACAGATCCTCTCTNCTCTGTCAAGCAGAAATGCAAGGCACTGAGCTGATCTTTCCANAATTTATCTANAGGTGCACACTGGGAGAGCTCCAGACCACACGACATGTATTCTGCGTCATGGCACTGCAGAGAAGGGACATGCATGCTGTTTGTACTGGAGGAGTAAAACCTCTACATGGGTCGAACGATGTGCAAGCATAAAATTGTGCTGAGACACACCGGTCTCTTAAGGTAAATACCTACATCAGGTG','1071','1','1','17'),('21','BP262043',0,NULL,'ACTTTATTACAGACCTTGGAAGCAAGAGGATTGCATTCAGCCTAGTTCCTGGTTGCTGGCCAAAGGGATCATGGACATTGAAGCATATTTTGAAAGAATTGGCTATAAGAACTCTAGGAACAAATTGGACTTGGAAACATTAACTGACATTCTTGAGCACCAGATCCGGGCTGTTCCCTTTGAGAACCTTAACATGCATTGTGGGCAAGCCATGGAGTTGGGCTTAGAGGCTATTTTTGATCACATTGTAAGAAGAAACCGGGGTGGGTGGTGTCTCCAGGTCAATCAACTTCTGTACTGGGCTCTGACCACAATCGGTTTTCAGACCACAATGTTAGGAGGGTATTTTTATATCCCTCCAGTTAACAAATACAGCACTGGCATGGTTCACCTTCTCCTGCAGGTGACCATTGACGGCAGGAATTACATTGTCGATGCTGGGTCTGGAAGCTCCTCCCAGATGTGGCAGCCTCTAGAATTAATTTCTGGGAAGGATCAGCCTCAGGtgccttgcattttctgcttgacagaagagagaggaaTCTGGTACCTGGACCAAATCAGGAGAGAGCAGTATATTAC','582','1','1','18'),('22','AU099534',0,NULL,'ACTTTATTACAGACCTTGGAAGCAAGAGGATTGCATTCAGCCTAGTTCCTGGTTGCTGGCCAAAGGGATCATGGACATTGAAGCATATTTTGAAAGAATTGGCTATAAGAACTCTAGGAACAAATTGGACTTGGAAACATTAACTGACATTCTTGAGCACCAGATCCGGGCTGTTCCCTTTGAGAACCTTAACATGCATTGTGGGCAAGCCATGGAGTTGGGCTTAGAGGCTATTTTTGATCACATTGTAAGAAGAAACCGGGGTGGGTGGTGTCTCCAGGTCAATCAACTTCTGTACTG','300','1','1','10'),('23','AI792606',0,NULL,'TCAGCCTAGTTTCTGGTTGCTGGCCAAAGGGATCATGGACATTGAAGCATATTTTGAAAGAATTGGCTATAAGAACTCTAGGAACAAATTGGACTTGGAAACATTAACTGACATTCTTGAGCACCAGATCCGGGCTGTTCCCTTTGAGAACCTTAACATGCATTGTGGGCAAGCCATGGAGTTGGGCTTAGAGGCTATTTTTGATCACATTGTAAGAAGAAACCGGGGTGGGTGGTGTCTCCAGGTCAATCAACTTCTGTACTGGGCTCTGACCACAATCGGTTTTCAGACCACAATGTTAGGAGGGTATTTTTACATCCCTCCAGTTAACAAATACAGCACTGGCATGGTTCACCTTCTCCTGCAGGTGACCATTGACGGCAGGAATTACATTGTCGATGCTGGGTCTGGAAGCTCCTCCCAGATGTGGCAGCCTCTAGAATTAATTTCTGGGAAGGATCAGCCTCAGGtgccttgcattttctgcttgacagaagagagaggaaTCTGGTACCTGGACCAAATCANGAGAGAGCAGTATATTACANACANAGAATNTCTTAATTCTCATCTNCTGCCANAGAAGAAACACCAGAANATATACTTATTTACGCTTGAACCTCGAACAATTGAAGAATTTGAGTCTATGAATACATACCTGCAGACGTCTCCAACATCTTTCATTATAACCACATCATTNTGTTNCTTGCAGACCCNAGGAGGGGTTTACTGGTTGGTGGGCTTCATCCTCACCTATAGAANAATCAATATAAAGACCATACAGATCTTGGCGAGTTTAAACTCT','805','1','1','6'),('24','BG204539',0,NULL,'ctttgcgcgcaaagctccaccgctgaggccaacgaggccaCTCCTTTATTCATTTACCAGTAAAAATTTACTATGAATGGGCAGTAAATCAATATTAAATGTTTTCTAGCATGAATCACTCTGCTTCCCAAGATAATCACAGGCcatccttaaaatgcctttatttttattaatttgaaaatgtgtccttatgtttctttaaaaagttattgttttttaataaaTGCGGGACATTTTTATGGATGAAAGTATTTGATGTTTAGGATTTTCTTCAAAATAACGTGAGGGTAGAGAGGATATCTGATAGCACATAAGTTGATAATTAGTGA','329','1','1','21'),('25','AI262683',0,NULL,'TTTTCCACAATATTCTTTATTCATTTACCAGTAAAAATTTACTATGAATTCAACAATAAATCAATATTAAATGTTTTCTAGCATGAATCACTCTGCTTCCCAAGATAATCACAGGCcatccttaaaatgcctttatttttattaatttgaaaatgtgtccttatgtttctttaaaaagttattgttttttaATAAATGCTGACATTTTTATGGATGAAAGTATTTGATGTTTAGGATTTTCTTCAAAATAACGTGAGGGTAGAGAGGATATCTGATAGCACATAAGTTGATAATTAGTGAGTTGGGTGATACATACACAAGGGTTTATTTTGTTCCTTATTCTAAATAGTAAGGGATCCATCACCAGGTTTGGGCACGAGATTTCTCCCCAAGGAAATCTTANATATATTTTTCAGCACTTCTTCAACCTCTTCCTCAGTGAGAGTTTTAAACTCGACCAGATCTGTATTGCTTTATAATTGATTTTCCATAGGTGAGATGAAGCCACCAACAGTACACCCTTCTGGGTCTGCAGGAACAAA','542','1','1','6'),('26','CB161982',0,NULL,'GGAAGCAAGAGGATTGCATTCAGCCTAGTTCCTGGTTGCTGGCCAAAGGGATCATGGACATTGAAGCATATTTTGAAAGAATTGGCTATAAGAACTCTAGGAACAAATTGGACTTGGAAACATTAACTGACATTCTTGAGCACCAGATCCGGGCTGTTCCCTTTGAGAACCTTAACATGCATTGTGGGCAAGCCATGGAGTTGGGCTTAGAGGCTATTTTTGATCACATTGTAAGAAGAAACCGGGGTGGGTGGTGTCTCCAGGTCAATCAACTTCTGTACTGGGCTCTGACCACAATCGGTTTTCAGACCACAATGTTAGGAGGGTATTTTTACATCCCTCCAGTTAACAAATACAGCACTGGCATGGTTCACCTTCTCCTGCAGGTGACCATTGACGGCAGGAATTACATTGTCGATGCTGGGTCTGGAAGCTCCTCCCAGATGTGGCAGCCTCTAGAATTAATTTCTGGGAAGGATCAGCCTCAGGtgccttgcattttctgcttgacagaagagagaggaaTCTGGTACCTGGACCAAATC','545','1','1','23'),('27','BG569293',0,NULL,'aatctgatagatcacctatagggcgctagctcggccgcagccgaacgaccgagcgcagcgacgtagtgagcgaggaagcggcgcataacttcgtatagcatacattatacgaagttatcagtcgacggtaccggacatatgcccgggaattcggccattacggccGGGGACTTCCCTTGCAGACTTTGGAAGGGAGAGCACTTTATTACAGACCTTGGAAGCAAGAGGATTGCATTCAGCCTAGTTCCTGGTTGCTGGCCAAAGGGATCATGGACATTGAAGCATATTTTGAAAGAATTGGCTATAAGAACTCTAGGAACAAATTGGACTTGGAAACATTAACTGACATTCTTGAGCACCAGATCCGGGCTGTTCCCTTTGAGAACCTTAACATGCATTGTGGGCAAGCCATGGAGTTGGGCTTAGAGGCTATTTTTGATCACATTGTAAGAAGAAACCGGGGTGGATGGTGTCTCCAGGTCAATCAACTTCTGTACTGGGCTCTGACCACAATCGGTTTTCAGACCACAATGTTAGGAGGGTATTTTTATATCCCTCCAGTTAACAAATACAGCACTGGCATGGTTCACCTTCTCCTGCAGGTGACCATTGACGGCAGGAATTACATTGTCGATGCTGGGTCTGGAAGCTCCTCCCAGATGTGGCAGCCTCTAGAATTAATTTCTGGGAAGGATCAGCCTCAGGtgccttgcattttctgcttgacagaagagagaggaaTCTGGTACCTGGACCAAATCAGGAGAGAGCAGTATATTACAAACAAAGAATTTCTTAATTCTCATCTCCTGCCAAAGAAGAAACACCAAAAAATATACTTATTTACGCTTGAACCTCAAACATTGAAGATTTCGAGTCTATGAATACATAACTGCAGACCGTCTCCAACATCTTCATTTATAAACCACATCATTTGTTCCTTGGCAGAACCCAAGAAGGGGTTTAACTGCTCGGGGGGCTTCAATCCTCACCTTATGA','999','1','1','24'),('31','BX095770',0,NULL,'TTTATACGACTNCACTNATNAGGGNAATTTGGNCCCTNCGNNGNCCAANAATNCGGCACGNAGGTNCAGCCTAGTTCCTGGTTGCTGGCCAAAGGGNATCATGGNACATTGAAGCATATTTTGAAAGAATTGGCTATAAGAACTCTAGGAACAAATTGGACTTGGAAACATTAACTGACATTCTTGAGCACCAGATCCGGGCTGTTCCCTTTGAGAACCTTAACATGCATTGTGGGCAAGCCATGGAGTTGGGCTTAGAGGCTATTTTTGATCACATTGTAAGAAGAAACCGGGGTGGGTGGTGTCTCCAGGTCAATCAACTTCTGTACTGGGCTCTGACCACAATCGGTTTTCAGACCACAATGTTAGGAGGGTATTTTTACATCCCTCCAGTTAACAAATACAGCACTGGCATGGTTCACCTTCTCCTGCAGGTGACCATTGACGGCAGGAATTACATTGTCGATGCTGGGTCTGGAAGCTCCTCCCAGATGTGGCAGCCTCTAGAATTAATTTCTGGGAAGGATCAGCCTCAGGTGCCTT','543','1','1','25'),('32','BP264356',0,NULL,'TTATTACAGACCTTGGAAGCAAGAGGATTGCATTCAGCCTAGTTCCTGGTTGCTGGCCAAAGGGATCATGGACATTGAAGCATATTTTGAAAGAATTGGCTATAAGAACTCTAGGAACAAATTGGACTTGGAAACATTAACTGACATTCTTGAGCACCAGATCCGGGCTGTTCCCTTTGAGAACCTTAACATGCATTGTGGGCAAGCCATGGAGTTGGGCTTAGAGGCTATTTTTGATCACATTGTAAGAAGAAACCGGGGTGGGTGGTGTCTCCAGGTCAATCAACTTCTGTACTGGGCTCTGACCACAATCGGTTTTCAGACCACAATGTTAGGAGGGTATTTTTACATCCCTCCAGTTAACAAATACAGCACTGGCATGGTTCACCTTCTCCTGCAGGTGACCATTGACGGCAGGAATTACATTGTCGATGCTGGGTCTGGAAGCTCCTCCCAGATGTGGCAGCCTCTAGAATTAATTTCTGGGAAGGATCAGCCTCAGGtgccttgcattttctgcttgacagaagagagaggaaTCTGGTACCTGGACCAAATCAGGAGAGAGCAGTATATTACAAAC','583','1','1','26'),('33','AV660442',0,NULL,'CTTTTATACTATTTCTTTATGGTCGATATACAATTGATTTTttaaaataatagcagatttcttgcttcatatgacaaagcCTCAATTACTAATTGTAAAAACTGAACTATTCCCAGAATCATGTTCAAAAAATCTGTAATTTTTGCTGATGAAAGTGCTTCATTGACTAAACAGTATTAGTTTGTGGCTATAAATGATTATTTAGATGATGACTGAAAATGTGTATAAAGTAATTAAAAGTAATATGGTGGCTTTAAGTGTAGAGATGGGATGGCAAATGCTGTGAATGCAGAATGTAGatatatatatacacatacatatatacacatataCAAATGTATATTTTTGCAN','351','1','1','27'),('35','AV661891',0,NULL,'CTTCTACCAATACACGGTGGTGGATGAGAATGCAGTGGGCAAGATTGATGCAGCCTTGCCCCTGGAGAAGTCTGCCTCATTGGCTGTGGATTCTCGACTGGTTATGGGTCTGCAGTTAACGTTGCCAAGGTCACCCCAGGCTCTACCTGTGCTGTGTTTGGCCTGGGAGGGGTCGGCCTATCTGCTGTTATGGGCTGTAAAGCAGCTGGAGCAGCCAGAATCATTGCGGTGGACATCAACTAGGACAAATTTGCAAAGGCCAAACAGTTGGGTGCCACTGAATGCATTAACCCTCaagactacaagaaacccatccaggaagtgctaAAGGAAATGACCGATGGAGGTGTGGATTCTTCGTTCGAAGTCATAGGACGGCTTGACACCATGATGGCTTCCCTGCTATGTTGTCATGAGGCATGTGGCACAAGCGTTATCCTAGGGGTACCTTCTGCTTTACAGACCTCTCATAAACCCTATGCTGCTACTGACTGGACGCACCTGGGAGGGGGCTGTTTATGGTTGCTCTGAGACGTAATGAATGTATNCCACAACTTTGCGGCTGATTNTATGGCTAAGAAGCTTTCACTGGATGCGTGTATACCCATGTTTTACCTTTTGAAAAATTAATGATGATTTGACCTGCTTACTCTAGTCACCC','661','1','1','29'),('38','AV649322',0,NULL,'GTTAAGCAAGACATCAACATGCAAATTCTGATTAAAAGGGGTCCATTATGATACAATTCAGGGAATTTCCACAAAAATCCTATGGAACAGTATCTTCCCCATTTAAAAGTTAATATGGTTTTACAGAAAATCAATGATACAATTTGAATAATAATACAATTTGAATCACTTAGCACTAGGAATACAGATATTTGGTTTTTTCTTCTATAAATTTGTACTTATTTGCTCAATGTGTTTACAGGTGCATGTGGTCATTCAATATAATCAATTGATTTTTTTAATTGTTTAATTACATAAACCTGTGCAACTATGTCCAGTCCTTTTTTTGTGTTAGGAGTGTACCACactgtaaaatatctcactatgataattcaatttaaAGGTTCTGAGGCTTCTCTCTGCATTGTGTGACAAACAGGCTCATATCAATAAGACTGGttgatggagctagaggacgttattctaagtaaagtaactcatgaatggaacaccaaatatccaatgttctcacttaaaagtggtagctaaactatgaggacacaaaggatgagaatgatataatggactttggngactgaggtaaaaggncagtangaggaataagacctaaaagactacataatgggttcaagctacacttgtttgtgtgaagggtgcaccaaaatatcgnaaattacccttaagaacttaatctgtaaccaaaaccattggaccccaaaacttatgaaattaaaataatcaatgataaatttagatt','757','1','1','32'),('45','AV661721',0,NULL,'CGGAAACGACATGAGCACAGCAGGAAAAGTGATCACATGCACAGCAGCTGTGCTATGGGAGGTGAAGAAACCCTTTTCCATATGAGGATGTGGAGGTTGCACCTCCTAAGGCTTATGAAGTTCGCATTAAGAAGGTGGCTGTAGGAATCTGTCACACAGATGACCACATGGTTAGTGGCAACCTGTGGACCCCCCTTCCTGTGAGTTTAGGCCATGaggcacccggcatcgtggagagtgttggagaagggGTGACTACAGTCAAACCAGGTGATAAAGGCATTCCGCTCTTTACTCCTCAGAGTGGAAAATGCACAGTTTGTGAAAACCCGGAGAGCGACTACTGCTTGG','351','1','1','39'),('185','AV719161',0,NULL,'AAAATGGGACAAAGAAGAATTCCAGAAATTTCTTTGAAAACTTCAGCTCTTCACAACAAGTTAGGCACTTTCTTTTAAGATAAGAATGGACTTAACAAATATTTTTAGCTGATAATTTGCGAATTATCTACTTTTCCTGTTATGGTGGAGGGAGTAGGGGTAAAAAGTAAGGCTGTCATTTTGTTGTTAATTTATTTCTAACTAAAGAAAATAGAGCTAAAACATACTTTGGATAGTTTATTTTATTATTTTCTGTTCACAGTTTAAATTGGTATTTGGTAAGGGGGCAGGGTGAATCTACAGGCTAAAGCAACTTTttaaaattaaacataatttttatttctaatcacctatgctatacattccacatgatcaagaaaaattgttggtacattaacattttataggtaaagtttatgtgaaaatgatggtatggcaATGTCCTAGTTATTAACCCTTTACTTCTAAAAGT','472','1','1','32');
UNLOCK TABLES;
/*!40000 ALTER TABLE `SEQUENCE` ENABLE KEYS */;

--
-- Table structure for table `TARGET`
--

DROP TABLE IF EXISTS `TARGET`;
CREATE TABLE `TARGET` (
  `TARGET_ID` decimal(10,0) NOT NULL default '0',
  `TARGET_NAME` varchar(50) default NULL,
  `TARGET_TYPE` varchar(50) default NULL,
  PRIMARY KEY  (`TARGET_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `TARGET`
--


/*!40000 ALTER TABLE `TARGET` DISABLE KEYS */;
LOCK TABLES `TARGET` WRITE;
INSERT INTO `TARGET` VALUES ('1','CDK4','GENE'),('2','CDKN1B','GENE'),('3','CDKN2A','GENE'),('4','CDKN2B','GENE'),('5','CTSB','GENE'),('6','DHFR','GENE'),('7','DPYD','GENE'),('8','EGFR','GENE'),('9','ERBB2','GENE'),('10','ESR1','GENE'),('11','ESR2','GENE'),('12','FAP','GENE'),('13','FGF2','GENE'),('14','FHIT','GENE'),('15','GLI','GENE'),('16','GM2A','GENE'),('17','GRB2','GENE'),('18','HDAC1','GENE'),('19','HGF','GENE'),('20','KDR','GENE'),('21','LAMR1','GENE'),('22','TACSTD1','GENE'),('23','MAGEA12','GENE'),('24','MDM2','GENE'),('25','MAP3K1','GENE'),('26','MET','GENE'),('27','MMP1','GENE'),('28','MMP2','GENE'),('29','MMP3','GENE'),('30','MMP9','GENE'),('31','MMP11','GENE'),('32','MMP13','GENE'),('33','MMP14','GENE'),('34','ABCC1','GENE'),('35','MUC1','GENE'),('36','MYC','GENE'),('37','NEU1','GENE'),('38','NF1','GENE'),('39','NF2','GENE'),('40','PKC','GENE'),('41','PDGFA','GENE'),('42','PDGFB','GENE'),('43','PDGFRA','GENE'),('44','PDGFRB','GENE'),('45','ABCB1','GENE'),('46','PLAUR','GENE'),('47','PRKACA','GENE'),('48','PRKCA','GENE'),('49','PRKCZ','GENE'),('50','PTEN','GENE'),('51','PTGS2','GENE'),('52','RAF1','GENE'),('53','RARA','GENE'),('54','RASA1','GENE'),('55','RB1','GENE'),('56','BCL2','GENE'),('57','BCL2L1','GENE'),('58','RXRA','GENE'),('59','CEACAM1','GENE'),('60','TF','GENE'),('61','TGFB1','GENE'),('62','THBS1','GENE'),('63','TITF1','GENE'),('64','TOP1','GENE'),('65','TOP2A','GENE'),('66','TOP2B','GENE'),('67','TP53','GENE'),('68','TYMS','GENE'),('69','VEGF','GENE'),('70','VHL','GENE'),('71','SSPN','GENE'),('72','TNFRSF10B','GENE'),('73','TNFRSF10A','GENE'),('74','CCNB1','GENE'),('75','CCND1','GENE'),('76','CCNE1','GENE'),('77','CD7','GENE'),('78','CD44','GENE'),('79','TUB','GENE'),('80','TERT','GENE'),('81','ABL1','GENE');
UNLOCK TABLES;
/*!40000 ALTER TABLE `TARGET` ENABLE KEYS */;

--
-- Table structure for table `TAXON`
--

DROP TABLE IF EXISTS `TAXON`;
CREATE TABLE `TAXON` (
  `TAXON_ID` decimal(10,0) NOT NULL default '0',
  `SCIENTIFIC_NAME` varchar(50) default NULL,
  `STRAIN_OR_ETHNICITY` varchar(50) default NULL,
  `COMMON_NAME` varchar(50) default NULL,
  `PREFERRED` tinyint(1) NOT NULL default '0',
  `ABBREVIATION` varchar(50) default NULL,
  PRIMARY KEY  (`TAXON_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `TAXON`
--


/*!40000 ALTER TABLE `TAXON` DISABLE KEYS */;
LOCK TABLES `TAXON` WRITE;
INSERT INTO `TAXON` VALUES ('5','Homo sapiens',NULL,NULL,1,'Hs'),('6','Mus musculus',NULL,NULL,1,'Mm'),('7','Mus musculus domesticus',NULL,NULL,0,'Mm'),('8','Mus musculus','129',NULL,0,'Mm'),('9','Mus musculus','129 - C57/B6 - FVBN',NULL,0,'Mm'),('10','Mus musculus','129/01a',NULL,0,'Mm'),('11','Mus musculus','129/Sv',NULL,0,'Mm'),('12','Mus musculus','129/sv',NULL,0,'Mm'),('13','Mus musculus','B6C3 F1',NULL,0,'Mm'),('14','Mus musculus','B6CBA',NULL,0,'Mm'),('15','Mus musculus','B6D2 F1/J',NULL,0,'Mm'),('16','Mus musculus','BALB/C',NULL,0,'Mm'),('17','Mus musculus','BALB/C x C57BL/6',NULL,0,'Mm'),('18','Mus musculus','BALB/c',NULL,0,'Mm'),('19','Mus musculus','BALB/cByJ',NULL,0,'Mm'),('20','Mus musculus','BXSB',NULL,0,'Mm'),('21','Mus musculus','Balb/cxDBA/2',NULL,0,'Mm'),('22','Mus musculus','Black 6',NULL,0,'Mm'),('23','Mus musculus','C3H',NULL,0,'Mm'),('24','Mus musculus','C3H x 101 (F1 stock)',NULL,0,'Mm'),('25','Mus musculus','C3H/An',NULL,0,'Mm'),('26','Mus musculus','C3H/HA',NULL,0,'Mm'),('27','Mus musculus','C3H/HeJ',NULL,0,'Mm'),('28','Mus musculus','C57',NULL,0,'Mm'),('29','Mus musculus','C57 BL-6',NULL,0,'Mm'),('30','Mus musculus','C57/B6',NULL,0,'Mm'),('31','Mus musculus','C57/Bl6',NULL,0,'Mm'),('32','Mus musculus','C57B1/6',NULL,0,'Mm'),('33','Mus musculus','C57B16 x DBA',NULL,0,'Mm'),('34','Mus musculus','C57BL',NULL,0,'Mm'),('35','Mus musculus','C57BL/6',NULL,0,'Mm'),('36','Mus musculus','C57BL/6 X SJL',NULL,0,'Mm'),('37','Mus musculus','C57BL/6 mouse',NULL,0,'Mm'),('38','Mus musculus','C57BL/6 x CBA',NULL,0,'Mm'),('39','Mus musculus','C57BL/6 x DBA',NULL,0,'Mm'),('40','Mus musculus','C57BL/6J',NULL,0,'Mm'),('41','Mus musculus domesticus','C57BL/6J',NULL,0,'Mm'),('42','Mus musculus','C57BL6 x DBA',NULL,0,'Mm'),('43','Mus musculus','C57Bl',NULL,0,'Mm'),('44','Mus musculus','C57Bl/6',NULL,0,'Mm'),('45','Mus musculus','C57Bl/6J',NULL,0,'Mm'),('46','Mus musculus','CBA',NULL,0,'Mm'),('47','Mus musculus','CD1',NULL,0,'Mm'),('48','Mus musculus','CF-1',NULL,0,'Mm'),('49','Mus musculus','CRH/HA',NULL,0,'Mm'),('50','Mus musculus','CRl: CD-1(ICR) BR',NULL,0,'Mm'),('51','Mus musculus','CZECH II',NULL,0,'Mm'),('52','Mus musculus','CZECH II (feral)',NULL,0,'Mm'),('53','Homo sapiens','Caucasian',NULL,0,'Hs'),('54','Mus musculus','DBA/2',NULL,0,'Mm'),('55','Mus musculus','F1',NULL,0,'Mm'),('56','Mus musculus','FVB',NULL,0,'Mm'),('57','Mus musculus','FVB/N',NULL,0,'Mm'),('58','Mus musculus','FVB/N-3',NULL,0,'Mm'),('59','Mus musculus','Heat loss',NULL,0,'Mm'),('60','Mus musculus','ICR',NULL,0,'Mm'),('61','Mus musculus','Inbred CD-1',NULL,0,'Mm'),('62','Mus musculus','NIH SWISS',NULL,0,'Mm'),('63','Mus musculus','NIH/Swiss',NULL,0,'Mm'),('64','Mus musculus','NMRI',NULL,0,'Mm'),('65','Mus musculus','NSA',NULL,0,'Mm'),('66','Mus musculus','SV129',NULL,0,'Mm'),('67','Mus musculus','Swiss',NULL,0,'Mm'),('68','Mus musculus','Swiss Webster',NULL,0,'Mm'),('69','Mus musculus','Swiss Webster/NIH',NULL,0,'Mm'),('70','Mus musculus','c57BL/6',NULL,0,'Mm'),('71','Homo sapiens','caucasian',NULL,0,'Hs'),('72','Mus musculus','mix of various GENEtic backgrounds',NULL,0,'Mm'),('73','Mus musculus','outbred',NULL,0,'Mm'),('74','Escherischia coli',NULL,NULL,0,'Ec'),('75','Rattus norvegicus',NULL,NULL,0,'Rn'),('76','Sacharomyces cerevisiae',NULL,NULL,0,'Sc'),('77','Caenorhabditis elegans',NULL,NULL,0,'Ce'),('78','Drosophila melanogaster',NULL,NULL,0,'Dm'),('79','Danio rerio',NULL,NULL,0,'Dr'),('80','Arabidopsis thaliana',NULL,NULL,0,'At'),('81','Saccharomyces cerevisiae','bub3','Budding Yeast',0,'Sc'),('82','Saccharomyces cerevisiae','mec2-1','Budding Yeast',0,'Sc'),('83','Saccharomyces cerevisiae','cln2 rad14','Budding Yeast',0,'Sc'),('84','Saccharomyces cerevisiae','mlh1 rad18','Budding Yeast',0,'Sc'),('85','Saccharomyces cerevisiae','sgs1 mgt1','Budding Yeast',0,'Sc'),('86','Saccharomyces cerevisiae','rad52','Budding Yeast',0,'Sc'),('87','Saccharomyces cerevisiae','rad14','Budding Yeast',0,'Sc'),('88','Saccharomyces cerevisiae','rad18','Budding Yeast',0,'Sc'),('90','Saccharomyces cerevisiae','SPY50780','Budding Yeast',0,'Sc'),('92','Saccharomyces cerevisiae','rad50EPP+','Budding Yeast',0,'Sc'),('93','Saccharomyces cerevisiae','sgs1','Budding Yeast',0,'Sc'),('94','Saccharomyces cerevisiae','mlh1','Budding Yeast',0,'Sc'),('95','Saccharomyces cerevisiae','mgt1','Budding Yeast',0,'Sc'),('96','Saccharomyces cerevisiae','wt','Budding Yeast',0,'Sc'),('97','Saccharomyces cerevisiae','CLN2oe','Budding Yeast',0,'Sc'),('98','Saccharomyces cerevisiae','mec2','Budding Yeast',0,'Sc'),('2002','Mus musculus','B6D2F1 (BDF1)','mouse',0,'Mm'),('2005','Mus musculus','BCF1','mouse',0,'Mm'),('2006','Mus musculus','CD2F1 (CDF1)','mouse',0,'Mm'),('2007','Mus musculus','C3H/He','mouse',0,'Mm'),('2008','Mus musculus','C3AKF1 (CHKRF1)','mouse',0,'Mm'),('2010','Mus musculus','BALB/CM','mouse',0,'Mm'),('2011','Mus musculus','C3B6F1','mouse',0,'Mm'),('2012','Mus musculus','CR:NIH(S)-nu','mouse',0,'Mm'),('2013','Mus musculus','AKR/J','mouse',0,'Mm'),('2014','Mus musculus','Athymic NCr-nu','mouse',0,'Mm'),('2015','Mus musculus','RFM/UN','mouse',0,'Mm'),('2016','Mus musculus','Balb/cAnNCr-nu','mouse',0,'Mm'),('2017','Mus musculus','NIH-II','mouse',0,'Mm'),('2018','Mus musculus','Cr:BG/nu (beige nude mice)','mouse',0,'Mm'),('2019','Mus musculus','D2B6F1 (DCF1)','mouse',0,'Mm'),('2020','Mus musculus','CDB1','mouse',0,'Mm'),('2021','Mus musculus','BAF1','mouse',0,'Mm'),('2022','Mus musculus','ABF1','mouse',0,'Mm'),('2023','Mus musculus','D2CF1 (DCF1)','mouse',0,'Mm'),('2024','Mus musculus','LAF1','mouse',0,'Mm'),('2025','Mus musculus','ALF1','mouse',0,'Mm'),('2026','Mus musculus','KRCHF1 (AKC3F1)','mouse',0,'Mm'),('2027','Mus musculus','AKR/Lw','mouse',0,'Mm'),('2028','Mus musculus','C57L','mouse',0,'Mm'),('2029','Mus musculus','A/L','mouse',0,'Mm'),('2030','Mus musculus','C3Hf/He','mouse',0,'Mm'),('2031','Mus musculus','CAF1','mouse',0,'Mm'),('2032','Mus musculus','C57BL/10SC','mouse',0,'Mm'),('2033','Mus musculus','NBL (mutation from C57BL/10H2d)','mouse',0,'Mm'),('2034','Mus musculus','A/He','mouse',0,'Mm'),('2035','Mus musculus','A/J','mouse',0,'Mm'),('2036','Mus musculus','BALB/cJ','mouse',0,'Mm'),('2037','Mus musculus','BALB/c An','mouse',0,'Mm'),('2038','Mus musculus','NZB','mouse',0,'Mm'),('2039','Mus musculus','NZW','mouse',0,'Mm'),('2040','Mus musculus','SJL/J','mouse',0,'Mm'),('2041','Mus musculus','SM/J','mouse',0,'Mm'),('2042','Mus musculus','CBA/J','mouse',0,'Mm'),('2043','Mus musculus','CAF1/N','mouse',0,'Mm'),('2044','Mus musculus','CAF1/J','mouse',0,'Mm'),('2045','Mus musculus','AKD2F1','mouse',0,'Mm'),('2046','Mus musculus','D2AKF1','mouse',0,'Mm'),('2047','Mus musculus','mouse species not specified','mouse',0,'Mm'),('2048','Mus musculus','C3D2F1','mouse',0,'Mm'),('2049','Mus musculus','ZWZBF1 (NZW/B1 x NZW/B1)','mouse',0,'Mm'),('2050','Mus musculus','ZBZWF1 (NZB/B1 x xNZW/B1)','mouse',0,'Mm'),('2051','Mus musculus','CFW/P1','mouse',0,'Mm'),('2052','Mus musculus','NIH/P1','mouse',0,'Mm'),('2053','Mus musculus','PRI/P1','mouse',0,'Mm'),('2054','Mus musculus','AL/N','mouse',0,'Mm'),('2055','Mus musculus','BALB/cfC3H','mouse',0,'Mm'),('2056','Mus musculus','DBA/8','mouse',0,'Mm'),('2057','Mus musculus','CD8F1','mouse',0,'Mm'),('2058','Mus musculus','random bred albino rat','mouse',0,'Mm'),('2059','Mus musculus','Fischer 344 rat','mouse',0,'Mm'),('2060','Mus musculus','Wistar-Furth rat','mouse',0,'Mm'),('2061','Mus musculus','Lewis rat','mouse',0,'Mm'),('2062','Mus musculus','Buffalo rat','mouse',0,'Mm'),('2063','Rattus norvegicus','AC1 rat','rat',0,'rn'),('2064','Mus musculus','Wistar rat','mouse',0,'Mm'),('2065','Mus musculus','Wistar/Lewis','mouse',0,'Mm'),('2066','Mus musculus','OM/N','mouse',0,'Mm'),('2067','Mus musculus','M520','mouse',0,'Mm'),('2068','Rattus norvegicus','August 28807','rat',0,'rn'),('2069','Rattus norvegicus','ACP (Piebald)','rat',0,'rn'),('2070','Rattus norvegicus','Albany','rat',0,'rn'),('2071','Mus musculus','Copenhagen 2331','mouse',0,'Mm'),('2072','Mus musculus','Zimmerman 61','mouse',0,'Mm'),('2073','Mus musculus','Yoshida 38366','mouse',0,'Mm'),('2074','Mus musculus','NBR/P1','mouse',0,'Mm'),('2075','Mus musculus','rat species not specified','mouse',0,'Mm'),('2076','Mus musculus','Syrian hamster','mouse',0,'Mm'),('2077','Mus musculus','Embryonated egg','mouse',0,'Mm'),('2078','Mus musculus','Cell culture tube assay','mouse',0,'Mm'),('2079','Mus musculus','Chemical analysis','mouse',0,'Mm'),('2080','Mus musculus','Cell culture chromatography','mouse',0,'Mm'),('2081','Mus musculus','Bioautography','mouse',0,'Mm'),('2082','Mus musculus','Cell-free systems','mouse',0,'Mm'),('2083','Mus musculus','Biochemical assay','mouse',0,'Mm'),('2084','Mus musculus','Microbial','mouse',0,'Mm'),('2085','Mus musculus','mouse, unknown','mouse',0,'Mm');
UNLOCK TABLES;
/*!40000 ALTER TABLE `TAXON` ENABLE KEYS */;

--
-- Table structure for table `csm_application`
--

DROP TABLE IF EXISTS `csm_application`;
CREATE TABLE `csm_application` (
  `APPLICATION_ID` bigint(20) NOT NULL auto_increment,
  `APPLICATION_NAME` varchar(100) NOT NULL default '',
  `APPLICATION_DESCRIPTION` varchar(200) NOT NULL default '',
  `DECLARATIVE_FLAG` tinyint(1) NOT NULL default '0',
  `ACTIVE_FLAG` tinyint(1) NOT NULL default '0',
  `UPDATE_DATE` date NOT NULL default '0000-00-00',
  PRIMARY KEY  (`APPLICATION_ID`),
  UNIQUE KEY `UQ_APPLICATION_NAME` (`APPLICATION_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `csm_application`
--


/*!40000 ALTER TABLE `csm_application` DISABLE KEYS */;
LOCK TABLES `csm_application` WRITE;
INSERT INTO `csm_application` VALUES (1,'upt','UPT Super Admin Application',0,0,'2006-10-17'),(2,'sdk','sdk',0,1,'2006-10-17');
UNLOCK TABLES;
/*!40000 ALTER TABLE `csm_application` ENABLE KEYS */;

--
-- Table structure for table `csm_group`
--

DROP TABLE IF EXISTS `csm_group`;
CREATE TABLE `csm_group` (
  `GROUP_ID` bigint(20) NOT NULL auto_increment,
  `GROUP_NAME` varchar(100) NOT NULL default '',
  `GROUP_DESC` varchar(200) default NULL,
  `UPDATE_DATE` date NOT NULL default '0000-00-00',
  `APPLICATION_ID` bigint(20) NOT NULL default '0',
  PRIMARY KEY  (`GROUP_ID`),
  UNIQUE KEY `UQ_GROUP_GROUP_NAME` (`APPLICATION_ID`,`GROUP_NAME`),
  KEY `idx_APPLICATION_ID` (`APPLICATION_ID`),
  CONSTRAINT `FK_APPLICATION_GROUP` FOREIGN KEY (`APPLICATION_ID`) REFERENCES `csm_application` (`APPLICATION_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `csm_group`
--


/*!40000 ALTER TABLE `csm_group` DISABLE KEYS */;
LOCK TABLES `csm_group` WRITE;
INSERT INTO `csm_group` VALUES (2,'{https://localhost:18443/wsrf/services/cagrid/GridGrouper}authztest:readers','','2006-10-18',2),(5,'readers','','2006-10-17',2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `csm_group` ENABLE KEYS */;

--
-- Table structure for table `csm_pg_pe`
--

DROP TABLE IF EXISTS `csm_pg_pe`;
CREATE TABLE `csm_pg_pe` (
  `PG_PE_ID` bigint(20) NOT NULL auto_increment,
  `PROTECTION_GROUP_ID` bigint(20) NOT NULL default '0',
  `PROTECTION_ELEMENT_ID` bigint(20) NOT NULL default '0',
  `UPDATE_DATE` date NOT NULL default '0000-00-00',
  PRIMARY KEY  (`PG_PE_ID`),
  UNIQUE KEY `UQ_PROTECTION_GROUP_PROTECTION_ELEMENT_PROTECTION_GROUP_ID` (`PROTECTION_ELEMENT_ID`,`PROTECTION_GROUP_ID`),
  KEY `idx_PROTECTION_ELEMENT_ID` (`PROTECTION_ELEMENT_ID`),
  KEY `idx_PROTECTION_GROUP_ID` (`PROTECTION_GROUP_ID`),
  CONSTRAINT `FK_PROTECTION_ELEMENT_PROTECTION_GROUP` FOREIGN KEY (`PROTECTION_ELEMENT_ID`) REFERENCES `csm_protection_element` (`PROTECTION_ELEMENT_ID`) ON DELETE CASCADE,
  CONSTRAINT `FK_PROTECTION_GROUP_PROTECTION_ELEMENT` FOREIGN KEY (`PROTECTION_GROUP_ID`) REFERENCES `csm_protection_group` (`PROTECTION_GROUP_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `csm_pg_pe`
--


/*!40000 ALTER TABLE `csm_pg_pe` DISABLE KEYS */;
LOCK TABLES `csm_pg_pe` WRITE;
INSERT INTO `csm_pg_pe` VALUES (1,1,3,'0000-00-00'),(2,1,4,'0000-00-00'),(3,2,5,'0000-00-00');
UNLOCK TABLES;
/*!40000 ALTER TABLE `csm_pg_pe` ENABLE KEYS */;

--
-- Table structure for table `csm_privilege`
--

DROP TABLE IF EXISTS `csm_privilege`;
CREATE TABLE `csm_privilege` (
  `PRIVILEGE_ID` bigint(20) NOT NULL auto_increment,
  `PRIVILEGE_NAME` varchar(100) NOT NULL default '',
  `PRIVILEGE_DESCRIPTION` varchar(200) default NULL,
  `UPDATE_DATE` date NOT NULL default '0000-00-00',
  PRIMARY KEY  (`PRIVILEGE_ID`),
  UNIQUE KEY `UQ_PRIVILEGE_NAME` (`PRIVILEGE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `csm_privilege`
--


/*!40000 ALTER TABLE `csm_privilege` DISABLE KEYS */;
LOCK TABLES `csm_privilege` WRITE;
INSERT INTO `csm_privilege` VALUES (1,'CREATE','This privilege grants permission to a user to create an entity. This entity can be an object, a database entry, or a resource such as a network connection','2006-10-17'),(2,'ACCESS','This privilege allows a user to access a particular resource.  Examples of resources include a network or database connection, socket, module of the application, or even the application itself','2006-10-17'),(3,'READ','This privilege permits the user to read data from a file, URL, database, an object, etc. This can be used at an entity level signifying that the user is allowed to read data about a particular entry','2006-10-17'),(4,'WRITE','This privilege allows a user to write data to a file, URL, database, an object, etc. This can be used at an entity level signifying that the user is allowed to write data about a particular entity','2006-10-17'),(5,'UPDATE','This privilege grants permission at an entity level and signifies that the user is allowed to update data for a particular entity. Entities may include an object, object attribute, database row etc','2006-10-17'),(6,'DELETE','This privilege permits a user to delete a logical entity. This entity can be an object, a database entry, a resource such as a network connection, etc','2006-10-17'),(7,'EXECUTE','This privilege allows a user to execute a particular resource. The resource can be a method, function, behavior of the application, URL, button etc','2006-10-17');
UNLOCK TABLES;
/*!40000 ALTER TABLE `csm_privilege` ENABLE KEYS */;

--
-- Table structure for table `csm_protection_element`
--

DROP TABLE IF EXISTS `csm_protection_element`;
CREATE TABLE `csm_protection_element` (
  `PROTECTION_ELEMENT_ID` bigint(20) NOT NULL auto_increment,
  `PROTECTION_ELEMENT_NAME` varchar(100) NOT NULL default '',
  `PROTECTION_ELEMENT_DESCRIPTION` varchar(200) default NULL,
  `OBJECT_ID` varchar(100) NOT NULL default '',
  `ATTRIBUTE` varchar(100) default NULL,
  `PROTECTION_ELEMENT_TYPE` varchar(100) default NULL,
  `APPLICATION_ID` bigint(20) NOT NULL default '0',
  `UPDATE_DATE` date NOT NULL default '0000-00-00',
  PRIMARY KEY  (`PROTECTION_ELEMENT_ID`),
  UNIQUE KEY `UQ_PE_PE_NAME_ATTRIBUTE_APP_ID` (`OBJECT_ID`,`ATTRIBUTE`,`APPLICATION_ID`),
  KEY `idx_APPLICATION_ID` (`APPLICATION_ID`),
  CONSTRAINT `FK_PE_APPLICATION` FOREIGN KEY (`APPLICATION_ID`) REFERENCES `csm_application` (`APPLICATION_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `csm_protection_element`
--


/*!40000 ALTER TABLE `csm_protection_element` DISABLE KEYS */;
LOCK TABLES `csm_protection_element` WRITE;
INSERT INTO `csm_protection_element` VALUES (1,'upt','UPT Super Admin Application','upt',NULL,NULL,1,'2006-10-17'),(2,'sdk',NULL,'sdk',NULL,NULL,1,'2006-10-17'),(3,'gov.nih.nci.cabio.domain.Gene','','gov.nih.nci.cabio.domain.Gene','',NULL,2,'2006-10-17'),(4,'gov.nih.nci.cabio.domain.Taxon','','gov.nih.nci.cabio.domain.Taxon','',NULL,2,'2006-10-17'),(5,'http://someservice/url','','http://someservice/url','',NULL,2,'2006-10-17');
UNLOCK TABLES;
/*!40000 ALTER TABLE `csm_protection_element` ENABLE KEYS */;

--
-- Table structure for table `csm_protection_group`
--

DROP TABLE IF EXISTS `csm_protection_group`;
CREATE TABLE `csm_protection_group` (
  `PROTECTION_GROUP_ID` bigint(20) NOT NULL auto_increment,
  `PROTECTION_GROUP_NAME` varchar(100) NOT NULL default '',
  `PROTECTION_GROUP_DESCRIPTION` varchar(200) default NULL,
  `APPLICATION_ID` bigint(20) NOT NULL default '0',
  `LARGE_ELEMENT_COUNT_FLAG` tinyint(1) NOT NULL default '0',
  `UPDATE_DATE` date NOT NULL default '0000-00-00',
  `PARENT_PROTECTION_GROUP_ID` bigint(20) default NULL,
  PRIMARY KEY  (`PROTECTION_GROUP_ID`),
  UNIQUE KEY `UQ_PROTECTION_GROUP_PROTECTION_GROUP_NAME` (`APPLICATION_ID`,`PROTECTION_GROUP_NAME`),
  KEY `idx_APPLICATION_ID` (`APPLICATION_ID`),
  KEY `idx_PARENT_PROTECTION_GROUP_ID` (`PARENT_PROTECTION_GROUP_ID`),
  CONSTRAINT `FK_PG_APPLICATION` FOREIGN KEY (`APPLICATION_ID`) REFERENCES `csm_application` (`APPLICATION_ID`) ON DELETE CASCADE,
  CONSTRAINT `FK_PROTECTION_GROUP` FOREIGN KEY (`PARENT_PROTECTION_GROUP_ID`) REFERENCES `csm_protection_group` (`PROTECTION_GROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `csm_protection_group`
--


/*!40000 ALTER TABLE `csm_protection_group` DISABLE KEYS */;
LOCK TABLES `csm_protection_group` WRITE;
INSERT INTO `csm_protection_group` VALUES (1,'Readable Domain Objects','',2,0,'2006-10-17',NULL),(2,'application','',2,0,'2006-10-17',NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `csm_protection_group` ENABLE KEYS */;

--
-- Table structure for table `csm_role`
--

DROP TABLE IF EXISTS `csm_role`;
CREATE TABLE `csm_role` (
  `ROLE_ID` bigint(20) NOT NULL auto_increment,
  `ROLE_NAME` varchar(100) NOT NULL default '',
  `ROLE_DESCRIPTION` varchar(200) default NULL,
  `APPLICATION_ID` bigint(20) NOT NULL default '0',
  `ACTIVE_FLAG` tinyint(1) NOT NULL default '0',
  `UPDATE_DATE` date NOT NULL default '0000-00-00',
  PRIMARY KEY  (`ROLE_ID`),
  UNIQUE KEY `UQ_ROLE_ROLE_NAME` (`APPLICATION_ID`,`ROLE_NAME`),
  KEY `idx_APPLICATION_ID` (`APPLICATION_ID`),
  CONSTRAINT `FK_APPLICATION_ROLE` FOREIGN KEY (`APPLICATION_ID`) REFERENCES `csm_application` (`APPLICATION_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `csm_role`
--


/*!40000 ALTER TABLE `csm_role` DISABLE KEYS */;
LOCK TABLES `csm_role` WRITE;
INSERT INTO `csm_role` VALUES (1,'reader','',2,1,'2006-10-17'),(2,'application_access','',2,1,'2006-10-17');
UNLOCK TABLES;
/*!40000 ALTER TABLE `csm_role` ENABLE KEYS */;

--
-- Table structure for table `csm_role_privilege`
--

DROP TABLE IF EXISTS `csm_role_privilege`;
CREATE TABLE `csm_role_privilege` (
  `ROLE_PRIVILEGE_ID` bigint(20) NOT NULL auto_increment,
  `ROLE_ID` bigint(20) NOT NULL default '0',
  `PRIVILEGE_ID` bigint(20) NOT NULL default '0',
  `UPDATE_DATE` date NOT NULL default '0000-00-00',
  PRIMARY KEY  (`ROLE_PRIVILEGE_ID`),
  UNIQUE KEY `UQ_ROLE_PRIVILEGE_ROLE_ID` (`PRIVILEGE_ID`,`ROLE_ID`),
  KEY `idx_PRIVILEGE_ID` (`PRIVILEGE_ID`),
  KEY `idx_ROLE_ID` (`ROLE_ID`),
  CONSTRAINT `FK_PRIVILEGE_ROLE` FOREIGN KEY (`PRIVILEGE_ID`) REFERENCES `csm_privilege` (`PRIVILEGE_ID`) ON DELETE CASCADE,
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`ROLE_ID`) REFERENCES `csm_role` (`ROLE_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `csm_role_privilege`
--


/*!40000 ALTER TABLE `csm_role_privilege` DISABLE KEYS */;
LOCK TABLES `csm_role_privilege` WRITE;
INSERT INTO `csm_role_privilege` VALUES (1,1,3,'0000-00-00'),(3,2,2,'0000-00-00');
UNLOCK TABLES;
/*!40000 ALTER TABLE `csm_role_privilege` ENABLE KEYS */;

--
-- Table structure for table `csm_user`
--

DROP TABLE IF EXISTS `csm_user`;
CREATE TABLE `csm_user` (
  `USER_ID` bigint(20) NOT NULL auto_increment,
  `LOGIN_NAME` varchar(100) NOT NULL default '',
  `FIRST_NAME` varchar(100) NOT NULL default '',
  `LAST_NAME` varchar(100) NOT NULL default '',
  `ORGANIZATION` varchar(100) default NULL,
  `DEPARTMENT` varchar(100) default NULL,
  `TITLE` varchar(100) default NULL,
  `PHONE_NUMBER` varchar(15) default NULL,
  `PASSWORD` varchar(100) default NULL,
  `EMAIL_ID` varchar(100) default NULL,
  `START_DATE` date default NULL,
  `END_DATE` date default NULL,
  `UPDATE_DATE` date NOT NULL default '0000-00-00',
  PRIMARY KEY  (`USER_ID`),
  UNIQUE KEY `UQ_LOGIN_NAME` (`LOGIN_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `csm_user`
--


/*!40000 ALTER TABLE `csm_user` DISABLE KEYS */;
LOCK TABLES `csm_user` WRITE;
INSERT INTO `csm_user` VALUES (1,'admin','admin','admin',NULL,NULL,NULL,NULL,'admin',NULL,NULL,NULL,'2006-10-17'),(2,'sdkadmin','sdk','admin','','','','','sdkadmin','',NULL,NULL,'2006-10-17'),(3,'reader','Read','Er','','','','','reader','reader@somewhere.com',NULL,NULL,'2006-10-17'),(4,'reader2','reader','2','','','','','reader2','',NULL,NULL,'2006-10-17');
UNLOCK TABLES;
/*!40000 ALTER TABLE `csm_user` ENABLE KEYS */;

--
-- Table structure for table `csm_user_group`
--

DROP TABLE IF EXISTS `csm_user_group`;
CREATE TABLE `csm_user_group` (
  `USER_GROUP_ID` bigint(20) NOT NULL auto_increment,
  `USER_ID` bigint(20) NOT NULL default '0',
  `GROUP_ID` bigint(20) NOT NULL default '0',
  PRIMARY KEY  (`USER_GROUP_ID`),
  KEY `idx_USER_ID` (`USER_ID`),
  KEY `idx_GROUP_ID` (`GROUP_ID`),
  CONSTRAINT `FK_UG_GROUP` FOREIGN KEY (`GROUP_ID`) REFERENCES `csm_group` (`GROUP_ID`) ON DELETE CASCADE,
  CONSTRAINT `FK_USER_GROUP` FOREIGN KEY (`USER_ID`) REFERENCES `csm_user` (`USER_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `csm_user_group`
--


/*!40000 ALTER TABLE `csm_user_group` DISABLE KEYS */;
LOCK TABLES `csm_user_group` WRITE;
INSERT INTO `csm_user_group` VALUES (1,3,5);
UNLOCK TABLES;
/*!40000 ALTER TABLE `csm_user_group` ENABLE KEYS */;

--
-- Table structure for table `csm_user_group_role_pg`
--

DROP TABLE IF EXISTS `csm_user_group_role_pg`;
CREATE TABLE `csm_user_group_role_pg` (
  `USER_GROUP_ROLE_PG_ID` bigint(20) NOT NULL auto_increment,
  `USER_ID` bigint(20) default NULL,
  `GROUP_ID` bigint(20) default NULL,
  `ROLE_ID` bigint(20) NOT NULL default '0',
  `PROTECTION_GROUP_ID` bigint(20) NOT NULL default '0',
  `UPDATE_DATE` date NOT NULL default '0000-00-00',
  PRIMARY KEY  (`USER_GROUP_ROLE_PG_ID`),
  KEY `idx_GROUP_ID` (`GROUP_ID`),
  KEY `idx_ROLE_ID` (`ROLE_ID`),
  KEY `idx_PROTECTION_GROUP_ID` (`PROTECTION_GROUP_ID`),
  KEY `idx_USER_ID` (`USER_ID`),
  CONSTRAINT `FK_USER_GROUP_ROLE_PROTECTION_GROUP_GROUPS` FOREIGN KEY (`GROUP_ID`) REFERENCES `csm_group` (`GROUP_ID`) ON DELETE CASCADE,
  CONSTRAINT `FK_USER_GROUP_ROLE_PROTECTION_GROUP_PROTECTION_GROUP` FOREIGN KEY (`PROTECTION_GROUP_ID`) REFERENCES `csm_protection_group` (`PROTECTION_GROUP_ID`) ON DELETE CASCADE,
  CONSTRAINT `FK_USER_GROUP_ROLE_PROTECTION_GROUP_ROLE` FOREIGN KEY (`ROLE_ID`) REFERENCES `csm_role` (`ROLE_ID`) ON DELETE CASCADE,
  CONSTRAINT `FK_USER_GROUP_ROLE_PROTECTION_GROUP_USER` FOREIGN KEY (`USER_ID`) REFERENCES `csm_user` (`USER_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `csm_user_group_role_pg`
--


/*!40000 ALTER TABLE `csm_user_group_role_pg` DISABLE KEYS */;
LOCK TABLES `csm_user_group_role_pg` WRITE;
INSERT INTO `csm_user_group_role_pg` VALUES (3,NULL,2,1,1,'2006-10-17'),(6,NULL,2,2,2,'2006-10-17'),(8,NULL,5,1,1,'2006-10-17'),(9,3,NULL,1,1,'2006-10-17');
UNLOCK TABLES;
/*!40000 ALTER TABLE `csm_user_group_role_pg` ENABLE KEYS */;

--
-- Table structure for table `csm_user_pe`
--

DROP TABLE IF EXISTS `csm_user_pe`;
CREATE TABLE `csm_user_pe` (
  `USER_PROTECTION_ELEMENT_ID` bigint(20) NOT NULL auto_increment,
  `PROTECTION_ELEMENT_ID` bigint(20) NOT NULL default '0',
  `USER_ID` bigint(20) NOT NULL default '0',
  `UPDATE_DATE` date NOT NULL default '0000-00-00',
  PRIMARY KEY  (`USER_PROTECTION_ELEMENT_ID`),
  UNIQUE KEY `UQ_USER_PROTECTION_ELEMENT_PROTECTION_ELEMENT_ID` (`USER_ID`,`PROTECTION_ELEMENT_ID`),
  KEY `idx_USER_ID` (`USER_ID`),
  KEY `idx_PROTECTION_ELEMENT_ID` (`PROTECTION_ELEMENT_ID`),
  CONSTRAINT `FK_PE_USER` FOREIGN KEY (`USER_ID`) REFERENCES `csm_user` (`USER_ID`) ON DELETE CASCADE,
  CONSTRAINT `FK_PROTECTION_ELEMENT_USER` FOREIGN KEY (`PROTECTION_ELEMENT_ID`) REFERENCES `csm_protection_element` (`PROTECTION_ELEMENT_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `csm_user_pe`
--


/*!40000 ALTER TABLE `csm_user_pe` DISABLE KEYS */;
LOCK TABLES `csm_user_pe` WRITE;
INSERT INTO `csm_user_pe` VALUES (1,1,1,'2006-10-17'),(2,2,2,'0000-00-00');
UNLOCK TABLES;
/*!40000 ALTER TABLE `csm_user_pe` ENABLE KEYS */;

--
-- Table structure for table `monkey`
--

DROP TABLE IF EXISTS `monkey`;
CREATE TABLE `monkey` (
  `MONKEY_ID` decimal(10,0) NOT NULL default '0',
  `NAME` varchar(50) default NULL,
  `TARGET_ID` decimal(10,0) default NULL,
  PRIMARY KEY  (`MONKEY_ID`),
  KEY `idx_TARGET_ID` (`TARGET_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `monkey`
--


/*!40000 ALTER TABLE `monkey` DISABLE KEYS */;
LOCK TABLES `monkey` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `monkey` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

