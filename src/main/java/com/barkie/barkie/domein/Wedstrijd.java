package com.barkie.barkie.domein;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Wedstrijd")
public class Wedstrijd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long wedstrijd_id;

    @Column(name = "BeginTijd")
    private LocalDateTime beginTijd;

    @Column(name = "KansThuis")
    private double kansThuis;

    @Column(name = "KansGelijk")
    private double kansGelijk;

    @Column(name = "KansUit")
    private double kansUit;

    @Column(name = "ScoreThuis")
    private int scoreThuis = 0;

    @Column(name = "ScoreUit")
    private int scoreUit = 0;

    @Column(name = "TeamThuis")
    private String teamThuis;

    @Column(name = "TeamUit")
    private String teamUit;

    @Column(name = "Competitie")
    private String competitie;

    @ManyToOne
    private Team thuisTeam;

    @ManyToOne
    private Team uitTeam;

    /** List containing Weddenschap objects */
    @OneToMany(mappedBy = "wedstrijd", cascade = CascadeType.ALL)
    private List<Weddenschap> weddenschappen;

    public Team getThuisTeam() {
        return thuisTeam;
    }

    public void setThuisTeam(Team thuisTeam) {
        this.thuisTeam = thuisTeam;
    }

    public Team getUitTeam() {
        return uitTeam;
    }

    public void setUitTeam(Team uitTeam) {
        this.uitTeam = uitTeam;
    }

    public String getTeamThuis() {
        return teamThuis;
    }

    public void setTeamThuis(String teamThuis) {
        this.teamThuis = teamThuis;
    }

    public String getTeamUit() {
        return teamUit;
    }

    public void setTeamUit(String teamUit) {
        this.teamUit = teamUit;
    }

    public String getCompetitie() {
        return competitie;
    }

    public void setCompetitie(String competitie) {
        this.competitie = competitie;
    }

    public long getWedstrijd_id() {
        return wedstrijd_id;
    }

    public LocalDateTime getBeginTijd() {
        return beginTijd;
    }

    public void setBeginTijd(LocalDateTime beginTijd) {
        this.beginTijd = beginTijd;
    }

    public double getKansThuis() {
        return kansThuis;
    }

    public void setKansThuis(double kansThuis) {
        this.kansThuis = kansThuis;
    }

    public double getKansGelijk() {
        return kansGelijk;
    }

    public double getKansUit() {
        return kansUit;
    }

    public void setKansUit(double kansUit) {
        this.kansUit = kansUit;
    }

    public int getScoreThuis() {
        return scoreThuis;
    }

    public void setScoreThuis(int scoreThuis) {
        this.scoreThuis = scoreThuis;
    }

    public int getScoreUit() {
        return scoreUit;
    }

    public void setScoreUit(int scoreUit) {
        this.scoreUit = scoreUit;
    }

    public List<Weddenschap> getWeddenschappen() {
        return weddenschappen;
    }

    public void setWeddenschappen(List<Weddenschap> weddenschappen) {
        this.weddenschappen = weddenschappen;
    }
}