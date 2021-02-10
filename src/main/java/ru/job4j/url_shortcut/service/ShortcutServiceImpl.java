package ru.job4j.url_shortcut.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.job4j.url_shortcut.domian.Site;
import ru.job4j.url_shortcut.domian.URL;
import ru.job4j.url_shortcut.repository.SiteRepository;
import ru.job4j.url_shortcut.repository.URLRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ShortcutServiceImpl implements ShortcutService {

    private final SiteRepository siteRepository;
    private final URLRepository urlRepository;
    private final BCryptPasswordEncoder encoder;

    public ShortcutServiceImpl(SiteRepository siteRepository,
                               URLRepository urlRepository,
                               BCryptPasswordEncoder encoder) {
        this.siteRepository = siteRepository;
        this.urlRepository = urlRepository;
        this.encoder = encoder;
    }

    @Override
    public Site saveSite(Site site) {
        if (siteRepository.findSiteByName(site.getName()).isEmpty()) {
            site.setEnabled(true);
            site.setLogin(UUID.randomUUID().toString());
            String password = UUID.randomUUID().toString();
            site.setPassword(encoder.encode(password));
            siteRepository.save(site);
            site.setPassword(password);
        }
        return site;
    }

    @Override
    public URL saveURL(URL url, String login) {
        url = urlRepository.findByUrl(url.getUrl()).orElse(url);
        if (url.getId() == 0) {
            url.setCode(UUID.randomUUID().toString());
            url.setSite(siteRepository.findSiteByLogin(login).get());
            url = urlRepository.save(url);
        }
        return url;
    }

    @Override
    public String getURLByCode(String code) {
        URL temp = urlRepository.findByCode(code).orElse(new URL());
        if (temp.getId() != 0) {
            urlRepository.incrementURL(temp.getId());
        }
        return temp.getUrl();
    }

    @Override
    public List<URL> getStatistic(String login) {
        Site site = siteRepository.findSiteByLogin(login).get();
        return (List<URL>) urlRepository.findAllBySite(site);
    }
}
