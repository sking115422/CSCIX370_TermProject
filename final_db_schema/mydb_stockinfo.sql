-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `stockinfo`
--

DROP TABLE IF EXISTS `stockinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stockinfo` (
  `stockTicker` varchar(10) NOT NULL,
  `stockName` varchar(100) DEFAULT NULL,
  `stockDesc` mediumtext,
  PRIMARY KEY (`stockTicker`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockinfo`
--

LOCK TABLES `stockinfo` WRITE;
/*!40000 ALTER TABLE `stockinfo` DISABLE KEYS */;
INSERT INTO `stockinfo` VALUES ('IWM','iShares Russell 2000 ETF','IWM is among the best choices in the crowded US small-cap field. The fund tracks the popular Russell 2000 index. IWM\'s broad basket makes it one of the most diversified funds in the segment. Notably, the fund delves into micro-cap territory, and has often been riskier than our neutral benchmark (as measured by beta) as a consequence. However, including micro-caps is a valid and possibly desirable approach to small-caps, and IWM looks reasonably similar to the benchmark in most other respects.'),('QQQ','Invesco QQQ Trust Series 1 ETF','QQQ is an ETF that includes 100 of the largest international and domestic companies listed on the Nasdaq stock exchange, just like the Nasdaq 100 Index that it tracks. The index excludes financial companies, and it is based on market capitalization. Therefore, QQQ stock holdings are heavily weighted toward large-cap technology companies.'),('SPY','SPDR S&P 500 Trust ETF','The SPDR S&P 500 trust is an exchange-traded fund which trades on the NYSE Arca under the symbol. SPDR is an acronym for the Standard & Poor\'stockinfos Depositary Receipts, the former name of the ETF. It is designed to track the S&P 500 stock market index. This fund is the largest ETF in the world'),('VTI','Vanguard Total Stock Market Index Fund ETF','The Vanguard Total Stock Market ETF (VTI) tracks the performance of the CRSP U.S. Total Market Index. The fund has returned 7.12% since its inception in 2001 (as of May 2020). The fund is a market capitalization-weighted index that measures the entire investable U.S. equity market. It includes small-, mid-, and large-cap companies. The fund is managed in a passive manner and uses an index-sampling strategy.');
/*!40000 ALTER TABLE `stockinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-30 23:35:09
