package ru.job4j.url_shortcut.service;

import ru.job4j.url_shortcut.domian.Site;
import ru.job4j.url_shortcut.domian.URL;

import java.util.List;

public interface ShortcutService {
    Site saveSite(Site site);

    URL saveURL(URL url, String siteName);

    String getURLByCode(String url);

    List<URL> getStatistic(String login);
}
