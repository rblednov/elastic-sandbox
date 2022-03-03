package ru.alfa.elasticsandbox.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ru.alfa.elasticsandbox.dto.pageindex.SitePage;

@Service
@AllArgsConstructor
public class SiteService {
    private final RestTemplate restTemplate;

    public List<String> getPageUrlList() {
        return List.of(
                "/get-money/mortgage/novostrojki/",
                "/get-money/mortgage/ipotechnaya-kvartira-kakie-prava-i-ogranicheniya-est-u-vladelca/",
                "/get-money/mortgage/kalkulyator-dosrochnoe-pogashenie/",
                "/get-money/mortgage/stavki/",
                "/get-money/mortgage/ipoteka-na-2000000-rublej/",
                "/get-money/mortgage/ipoteka-na-7000000-rublej/",
                "/get-money/credit-cards/bez-spravok-o-doxodax/",
                "/get-money/mortgage/ipoteka-na-3-goda/",
                "/get-money/mortgage/articles/kak-vzyat-semeynuyu-ipoteku/",
                "/get-money/mortgage/chto-nuzhno-chtoby-odobrili-ipoteku/",
                "/_example/sme/404/",
                "/get-money/mortgage/complete_house_short_b/",
                "/get-money/mortgage/ipoteka-pod-nizkij-procent/",
                "/get-money/mortgage/ipoteka-na-5-let/",
                "/_example/dc/dc-cashback-calculator/a/",
                "/get-money/mortgage/strahovanie-nedvizhimosti/",
                "/_example/cpas/card_carousel/",
                "/_example/cpas/main_carousel_tabs/",
                "/get-money/credit-cards/friend-share/",
                "/_example/cpas/person_card_with_detail/",
                "/sme/profits/zalogoviilite/",
                "/sme/profits/overdraft/",
                "/get-money/credit-cards/pokupki/",
                "/get-money/credit-cards/puteshestviya/",
                "/get-money/credit-cards/bez-dokumentov/",
                "/get-money/credit-cards/land/100-days-installment/",
                "/sme/profits/zalogoviilite-new/",
                "/get-money/credit-cards/pyaterochka/",
                "/sme/profits/bussineskredit/",
                "/sme/profits/businessipoteka/",
                "/sme/profits-new/",
                "/sme/profits-cards/",
                "/sme/agent/creditline/",
                "/sme/profits/",
                "/sme/agent/profits/partner/",
                "/sme/cards/creditcard/",
                "/get-money/mortgage/ipoteka-pod-6-procentov/",
                "/sme/profits/businesscredit/",
                "/sme/profits/partner/",
                "/sme/profits/partner-new/",
                "/sme/profits/businesscredit3months/",
                "/sme/agent/businesscredit3months/",
                "/sme/profits/businesscredit3monthsnib/",
                "/get-money/mortgage/socialnaya-ipoteka/",
                "/sme/profits/businesscredit3monthsabm/",
                "/sme/profits/businesscredit3monthscc/",
                "/lp/retail/start/",
                "/sme/cards/businesscard/",
                "/sme/raschetnyj-schet/ip/valytnyi-schet/",
                "/get-money/mortgage/mozhno-li-prodat-kvartiru-v-ipoteke/",
                "/get-money/mortgage/ipoteka-na-10-mln-rublej/",
                "/_example/investments/calculator/iis/",
                "/_example/investments/calculator/pifs/",
                "/_example/widgets/tiles/",
                "/retail/information/department/",
                "/everyday/debit-cards/novosibirsk/",
                "/_example/dc/tabs-with-card-carousel/",
                "/_example/cpas/checkbox/",
                "/retail/information/currency/",
                "/make-money/investments/promo/23-fevralya-test/",
                "/make-money/investments/tariffs/",
                "/make-money/investments/promo/otkrojte-brokerskij-schyot/",
                "/make-money/investments/promo/22percent/beeline/",
                "/get-money/credit-cards/faq/chto-takoe-besprocentnyj-period-kreditovaniya/",
                "/make-money/investments/",
                "/_example/cpas/online-applications/",
                "/make-money/investments/rebrending-alfa-direct/",
                "/get-money/credit-cards/100-days-salary/",
                "/make-money/investments/trading-account/",
                "/make-money/investments/kvalificirovannyy-investor/",
                "/get-money/credit-cards/dlya-snyatiya-nalichnyx/",
                "/make-money/investments/nszh/alfa-zdorove/",
                "/_example/common/context_props_overrider_with_provider/",
                "/make-money/investments/promo/luchshij-chastnyj-investor-goda/",
                "/_example/dc/dc-form-short/vertical-progress/",
                "/help/articles/investments/chto-takoe-iis/",
                "/_example/dc/dc-form-short/vertical-progress-grey/",
                "/lp/retail/special/",
                "/_example/cpas/personal_offers/",
                "/_base_instance_test/components/",
                "/everyday/debit-cards/s-dostavkoj/",
                "/make-money/investments/learn/valuta/",
                "/make-money/investments/learn/portfel-1/",
                "/_example/dc/dc-cashback-calculator/",
                "/_base_instance_test/",
                "/get-money/credit-cards/faq/skolko-kreditov-mozhno-oformit-v-techenie-goda/",
                "/help/articles/investments/chto-takoe-investicii/",
                "/_example/common/js-error/",
                "/get-money/mortgage/usloviya-oformleniya-ipoteki/",
                "/_example/sme/credit-prescoring/",
                "/help/articles/investments/kuda-investirovat-nebolshie-summy-deneg/",
                "/get-money/credit-cards/s-18-let/",
                "/_example/dc/dc-form-short/phone-first/",
                "/everyday/debit-cards/sankt-peterburg/",
                "/qr/testMasha/help/faq/all-copy/",
                "/_example/cpas/cards/",
                "/atm/",
                "/get-money/credit-cards/s-lgotnym-periodom/",
                "/get-money/credit-cards/s-lgotnym-snyatiem-nalichnyx/",
                "/",
                "/sme/",
                "/everyday/debit-cards/",
                "/cards/",
                "/make-money/",
                "/get-money/mortgage/",
                "/make-money/investments/",
                "/sme/profits-new/",
                "/sme/deposits/");
    }

    public SitePage getJsonPageByUrl(String url) {
        Map<String, List<String>> requestHeaders = new HashMap<>();
        HttpEntity httpEntity = new HttpEntity(requestHeaders);
        ResponseEntity<String> responseEntity =
                restTemplate.exchange("http://preprod.ci.k8ng.alfa.link/as-json" + url,
                        HttpMethod.GET,
                        httpEntity,
                        String.class);
        return SitePage.builder()
                .body(responseEntity.getBody())
                .url(url)
                .headers(responseEntity.getHeaders())
                .build();
    }

    public SitePage getHtmlPageByUrl(String url) {
        Map<String, List<String>> requestHeaders = new HashMap<>();
        HttpEntity httpEntity = new HttpEntity(requestHeaders);
        ResponseEntity<String> responseEntity =
                restTemplate.exchange("http://preprod.ci.k8ng.alfa.link" + url,
                        HttpMethod.GET,
                        httpEntity,
                        String.class);
        return SitePage.builder()
                .body(responseEntity.getBody())
                .url(url)
                .headers(responseEntity.getHeaders())
                .build();
    }
}
