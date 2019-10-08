package io.github.pashazz.walker.entities;



import javax.persistence.*;


@NamedQueries({
        @NamedQuery(name = "point.start.by.walkId", query = "from Point where walk.id=:walkId and type='START'")
        @NamedQuery(name = "point.stop.by.walkId", query = "from Point where walk.id=:walkId and type='STOP'")
})

@Entity
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Double lat;

    @Column(nullable = false)
    private Double lon;


    @Enumerated(EnumType.STRING)
    private PointType type;


    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_point_walk"))
    private Walk walk;

    public Point () {}

    public Point(Walk walk, Double lat, Double lon, PointType type) {
        this.walk = walk;
        this.lat = lat;
        this.lon = lon;
        this.type = type;
    }

}
