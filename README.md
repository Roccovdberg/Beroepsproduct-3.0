# Implementatieplan MyTurn

## Inleiding
Dit systeem is ontwikkeld omdat veel mensen producten hebben die ze bereid zijn uit te lenen, maar niet weten aan wie. Daarom is er een systeem gemaakt waar mensen producten kunnen toevoegen, bewerken, bekijken en verwijderen.

## Doelstellingen
- Gebruikers kunnen producten toevoegen, bewerken en verwijderen.
- Alle wijzigingen aan producten worden bijgewerkt in een MySQL-database.

## Technologieën
- Programmeertalen: JavaFX, MySQL.
- Database: MySQL voor het opslaan van producten, contracten en accounts.
- Versiebeheer: Git en GitHub voor samenwerking en versiebeheer.
- Testen: Unittests zijn uitgevoerd.

## Stappenplan
1. **Inloggen**: Gebruikers loggen in op het systeem of maken een nieuw account aan. Accounts worden toegevoegd aan de database.
2. **Homepagina**: Na het inloggen komen gebruikers op de homepagina terecht. Hier kunnen ze producten bekijken en nieuwe toevoegen.
3. **Product toevoegen**: Gebruikers kunnen via een invulformulier informatie over een product invoeren. Dit wordt toegevoegd aan de database en getoond op het scherm.
4. **Contract maken**: Als een gebruiker interesse heeft in een product, kunnen ze samen een contract opstellen via een formulier. Dit wordt opgeslagen in de database.
5. **Product bewerken**: Gebruikers kunnen op een product klikken om informatie te bewerken. Alle wijzigingen worden automatisch bijgewerkt in de database.
6. **Product verwijderen**: Als een gebruiker besluit een product niet meer te willen uitlenen, kunnen ze het verwijderen. Dit wordt ook verwijderd uit de database.

## Conclusie
Het implementatieplan voor MyTurn biedt een gestructureerde aanpak voor het ontwikkelen van een systeem waarin gebruikers producten kunnen beheren voor verhuur aan anderen. MyTurn zal bijdragen aan het vergemakkelijken van het delen van producten binnen gemeenschappen, terwijl gebruikers tegelijkertijd de controle behouden over hun verhuurprocessen.