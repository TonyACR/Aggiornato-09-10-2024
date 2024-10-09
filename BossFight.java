public class BossFight {
    Boss bossKalameetBossDrago = new Boss();
    Boss bossGwynLordOfCinderBossGuerriero = new Boss();
    Mappa mappaCastelloDiDragleic = new Mappa();
    // ancora da definire la scelta della calsse del giocatore
    Classi classeScelta = new Classi();
    public boolean scontroFinito = false;
    public boolean turnoGiocatore = true;
    public boolean turnoBoss = false;

    public void BossFightKalameet(Giocatore giocatore, RandomEvent randomEvent, Classi classi) {
        System.out.println("Boss Fight Kalameet iniziata");
        System.out.println("Sei all'interno del castello di Drangleic");
        mappaCastelloDiDragleic.CastelloDiDragleic();

        System.out.println("Nome giocatore da definire contro Kalameet");

        bossKalameetBossDrago.ApparizioneBossKalameet();
        System.out.print(" VS ");
        if (cS == 1) {
            classeScelta.ApparizionePersonaggioMagia();
        }
        if (cS == 2) {
            classeScelta.ApparizionePersonaggioDestrezza();
        }
        if (cS == 3) {
            classeScelta.ApparizionePersonaggioForza();
        }
        System.out.println("Inizio scontro");

        while (scontroFinito) {

            if (giocatore.salute == 0 || bossKalameetBossDrago.saluteKalameet == 0) {
                scontroFinito = true;
            }
            if (turnoGiocatore) {
                turnoBoss = false;
                System.out.println("E' il turno del giocatore ");
                if (cS == 1) {
                    classeScelta.MosseMagia();
                }
                if (cS == 2) {
                    classeScelta.MosseDestrezza();
                    if (classi.mSd == 1) {
                        bossKalameetBossDrago.saluteKalameet -= potenzaAttaccoDFendenteMortale;
                    }
                    if (classi.mSd == 2) {
                        bossKalameetBossDrago.saluteKalameet -= potenzaAttaccoDRespirazioneDellaTighre;

                    }
                }
                if (cS == 3) {
                    classeScelta.MosseForza();
                    if (mSf == 1) {
                        bossKalameetBossDrago.saluteKalameet -= potenzaAttaccoFAttaccoDirompente;

                    }
                    if (mSf == 2) {
                        bossKalameetBossDrago.saluteKalameet -= potenzaAttaccoFMartelloDellaDistruzione;

                    }
                }
                turnoBoss = true;
            }
            if (turnoBoss) {
                System.out.println("E' il turno del boss");
                bossKalameetBossDrago.FunzionamentoBossKalameet();
            }
            if (giocatore.salute == 0) {
                System.out.println("Scontro perso dal giocatore");
                giocatore.morto = true;
            } else {
                System.out.println("Scontro vinto da Kalameet");
            }
        }

    }
}