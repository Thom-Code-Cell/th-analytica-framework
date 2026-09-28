# Visual AI Visibility: messbare Bildsuche und Bildkontext

Status: **Prüfmodul in Dimension 2 und 6, keine neue Score-Achse**  
Stand: 28. September 2026

## Zweck und Evidenzgrenze

Google kündigte am 24. September 2026 einen Search-Console-Filter für *web multimodal search* in den Search- und Generative-AI-Performance-Berichten an. Er umfasst laut Google unter anderem Lens, Circle to Search, Bild-Uploads und „Search this image“. Der Rollout erfolgt schrittweise; die Metriken erscheinen, wenn eine Property Traffic aus solchen Suchanfragen erhält. Ein fehlender Filter oder leere Daten sind **kein Beweis**, dass Bildinhalte für KI-Systeme unsichtbar sind. Ein Bildsuche-Klick ist weder eine KI-Empfehlung noch ein nachgewiesener Geschäftserfolg.

Primärquelle: https://developers.google.com/search/blog/2026/09/web-multimodal-in-sc

## Messprotokoll (nur mit berechtigter Property oder Kundenexport)

1. Property, Eigentümerfreigabe, Berichtsoberfläche, Datum und Zeitzone festhalten. Zustand des Multimodal-Filters getrennt als `available`, `not_available`, `available_no_data` oder `not_checked` erfassen.
2. Vor einer Änderung einen unveränderten Vergleichszeitraum sichern. Im Search-Performance-Bericht und – falls zugänglich – im Bericht für Generative-AI-Funktionen den multimodalen Suchtyp wählen und Daten über **Export** sichern. Exportdatum, Zeitraum, Suchtyp, Berichtsart und angewendete Filter dokumentieren.
3. Impressionen, Klicks, CTR, Zielseiten, Länder und Geräte nur dort auswerten, wo die Oberfläche sie tatsächlich liefert. Kleine Werte, fehlende Dimensionen und Datenschutzfilter dokumentieren; nicht auf Null ergänzen.
4. Web-multimodal und generative KI als **getrennte Beobachtungen** ausweisen. Keine Doppelzählung über Berichte; keine Umdeutung von Traffic zu Zitierung, Empfehlung oder Attribution.
5. Nach einer dokumentierten Bild-/Seitenänderung einen gleich langen Vergleichszeitraum sichern; Saisonalität, allgemeine Suchänderungen und den Rollout als alternative Erklärungen nennen.

Datensatz je Beobachtung: `property`, `report`, `filter`, `period`, `exportedAt`, `landingPage`, `country`, `device`, `impressions`, `clicks`, `dataState`, `sourceFile`. Nur Felder befüllen, die im Export vorhanden sind.

## Visueller Seiten- und Asset-Check

Für relevante Hotels, Geschäfte, Restaurants, Produkte, Ausflugsziele und die eigene Website:

- Repräsentatives Originalbild, Logo, Produkt-, Gebäude- oder Menübild identifizieren; Lizenz und Aktualität prüfen.
- Dateiname und Alt-Text auf genaue, knappe Beschreibung prüfen; dekorative Bilder korrekt als solche behandeln. Kein Keyword-Stuffing.
- Bildqualität, Erreichbarkeit für Crawler, Lade-/Renderpfad, relevante Bild-Sitemap oder `og:image` und sichtbaren Seitenkontext prüfen.
- Wo sinnvoll, sichtbare Fakten, Entität, Standort/Produkt/Angebot und passende strukturierte Daten auf Widersprüche prüfen. Markup muss mit dem sichtbaren Inhalt übereinstimmen.
- Für Speisekarten/Preislisten die Lesbarkeit, Aktualität und einen zugänglichen HTML- oder Textpfad zusätzlich zum Bild/PDF prüfen; keine Preise aus Bildern schätzen.
- Je Asset eine konkrete Feststellung mit URL/Screenshot/Datum und Freigabe für Korrekturen dokumentieren.

## Status und Reporting

Ein Befund durchläuft `erkannt → vorgeschlagen → umgesetzt → verifiziert`. **Erkannt** ist eine reproduzierbare Beobachtung, **vorgeschlagen** eine konkrete Änderung, **umgesetzt** der nachweisbare Release, **verifiziert** eine technische Nachprüfung mit Datum und Quelle. Nur eine zusätzliche, geeignete Wirkungsmessung darf eine spätere Ergebnisänderung belegen. Ein Vorschlag oder ein geändertes Bild erhält keinen künstlichen Erfolgsstatus.

Visual AI Visibility ergänzt die bestehende Vollanalyse; sie ist kein Google-Rankingfaktor, keine Garantie für Lens-Traffic und kein Ersatz für Bildrechte, Accessibility oder echte Kundenergebnisse.
