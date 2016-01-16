package com.acme.ads.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.acme.ads.exceptions.AcmeAdsSystemException;
import com.acme.ads.model.Advertisement;
import com.acme.ads.model.Advertisements;
import com.acme.ads.model.NewsAds;
import com.acme.ads.model.NewsPaper;
import com.acme.ads.model.NewsPaperAdvertisements;
import com.acme.ads.model.NewsPapers;

@Named("acmeAdsDaoImpl")
public class AcmeAdsDaoImpl implements AcmeAdsDao {
	private static final Logger log = Logger.getLogger(AcmeAdsDaoImpl.class);

	public int createNewsPaper(NewsPaper newsPaper) throws Exception {
		log.debug("Creating NewsPaper...");
		JAXBContext jaxbContext = JAXBContext.newInstance(NewsPapers.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		List<NewsPaper> newsPapers = getNewsPapers();
		if (newsPapers.contains(newsPaper)) {
			log.debug("NewsPaper already exist...");
			return 2;
		}
		newsPaper.setNewsPaperId(newsPapers.size() + 1);
		newsPapers.add(newsPaper);
		NewsPapers jaxbNewsPapers = new NewsPapers();
		jaxbNewsPapers.setNewsPaper(newsPapers);
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		try {
			File file = new File("C:\\AcmeAds\\NewsPapers.xml");
			jaxbMarshaller.marshal(jaxbNewsPapers, file);
			jaxbMarshaller.marshal(jaxbNewsPapers, System.out);
		} catch (Exception e) {
			throw new AcmeAdsSystemException("Unable to create NewsPaper..."
					+ e.getMessage());
		}
		return 1;
	}

	public List<NewsPaper> getNewsPapers() throws Exception {
		JAXBContext jaxbContext;
		NewsPapers newsPapers;
		try {
			jaxbContext = JAXBContext.newInstance(NewsPapers.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Reader reader = new FileReader("C:\\AcmeAds\\NewsPapers.xml");
			if (reader.read() == -1) {
				newsPapers = new NewsPapers();
			} else {
				newsPapers = (NewsPapers) jaxbUnmarshaller
						.unmarshal(new FileReader("C:\\AcmeAds\\NewsPapers.xml"));
			}
		} catch (JAXBException e) {
			throw new AcmeAdsSystemException("Unable to create NewsPaper..."
					+ e.getMessage());
		} catch (FileNotFoundException e) {
			throw new AcmeAdsSystemException(
					"Unable to locate NewsPaper XML file..." + e.getMessage());
		}
		return newsPapers.getNewsPaper();
	}

	public int createAdvertisement(Advertisement advertisement)
			throws Exception {
		File file = new File("C:\\AcmeAds\\Advertisements.xml");
		JAXBContext jaxbContext;

		jaxbContext = JAXBContext.newInstance(Advertisements.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		List<Advertisement> advertisements = getAdvertisements();
		if (advertisements.contains(advertisement)) {
			log.debug("NewsPaper already exist...");
			return 2;
		}
		advertisement.setAdvId(advertisements.size() + 1);
		advertisements.add(advertisement);
		Advertisements jaxbAds = new Advertisements();
		jaxbAds.setAdvertisements(advertisements);
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		try {
			jaxbMarshaller.marshal(jaxbAds, file);
			jaxbMarshaller.marshal(jaxbAds, System.out);
		} catch (Exception e) {
			throw new AcmeAdsSystemException(
					"Unable to create Advertisement..." + e.getMessage());
		}
		return 1;
	}

	public List<Advertisement> getAdvertisements() throws Exception {
		JAXBContext jaxbContext;
		Advertisements advertisements;
		try {
			jaxbContext = JAXBContext.newInstance(Advertisements.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Reader reader = new FileReader("C:\\AcmeAds\\Advertisements.xml");
			if (reader.read() == -1) {
				advertisements = new Advertisements();
			} else {
				advertisements = (Advertisements) jaxbUnmarshaller
						.unmarshal(new FileReader(
								"C:\\AcmeAds\\Advertisements.xml"));
			}
		} catch (JAXBException e) {
			throw new AcmeAdsSystemException("Unable to get Advertisements..."
					+ e.getMessage());
		} catch (FileNotFoundException e) {
			throw new AcmeAdsSystemException(
					"Unable to locate Advertisements XML file..."
							+ e.getMessage());
		}
		return advertisements.getAdvertisements();
	}

	public int createNewsAds(NewsAds newsAd) throws Exception {
		File file = new File("C:\\AcmeAds\\NewsAds.xml");
		JAXBContext jaxbContext;
		jaxbContext = JAXBContext.newInstance(NewsPaperAdvertisements.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		List<NewsAds> newsAdList = getNewsAds();
		if (newsAdList.contains(newsAd)) {
			log.debug("News Advertisement already exist...");
			return 2;
		}
		newsAdList.add(newsAd);
		NewsPaperAdvertisements jaxbNewsAds = new NewsPaperAdvertisements();
		jaxbNewsAds.setNewsPaperAds(newsAdList);
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		try {

			jaxbMarshaller.marshal(jaxbNewsAds, file);
			jaxbMarshaller.marshal(jaxbNewsAds, System.out);
		} catch (Exception e) {
			throw new AcmeAdsSystemException(
					"Unable to create NewsPaperAdvertisement..."
							+ e.getMessage());
		}
		return 1;
	}

	public List<NewsAds> getNewsAds() throws Exception {
		JAXBContext jaxbContext;
		NewsPaperAdvertisements newsAds;
		try {
			jaxbContext = JAXBContext
					.newInstance(NewsPaperAdvertisements.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Reader reader = new FileReader("C:\\AcmeAds\\NewsAds.xml");
			if (reader.read() == -1) {
				newsAds = new NewsPaperAdvertisements();
			} else {
				newsAds = (NewsPaperAdvertisements) jaxbUnmarshaller
						.unmarshal(new FileReader("C:\\AcmeAds\\NewsAds.xml"));
			}
		} catch (JAXBException e) {
			throw new AcmeAdsSystemException(
					"Unable to get NewsPaperAdvertisements..." + e.getMessage());
		} catch (FileNotFoundException e) {
			throw new AcmeAdsSystemException(
					"Unable to locate NewsPaperAdvertisements XML file..."
							+ e.getMessage());
		}
		return newsAds.getNewsPaperAds();
	}

}
