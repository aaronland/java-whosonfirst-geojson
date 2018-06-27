# java-whosonfirst-geojson

This is not for you, yet. I am still trying to feel the "shape" of Java. It's not you, it's me.

## Build

This uses [Maven](https://maven.apache.org/) to manage dependencies and to build packages. Choose your poison, right?

```
mvn clean install
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building helloworld 0.0.1
[INFO] ------------------------------------------------------------------------

... Java stuff happens

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.674 s
[INFO] Finished at: 2018-06-27T13:53:06+00:00
[INFO] Final Memory: 20M/266M
[INFO] ------------------------------------------------------------------------
```

## Usage

```
java -jar ./target/hellworld-0.0.1.jar /usr/local/data/dist/whosonfirst-data/data/1/1.geojson
/usr/local/data/dist/whosonfirst-data/data/1/1.geojson
com.github.filosganga.geogson.model.Feature@dcc258e6
{"id":"1","type":"Feature","properties":{"geom:latitude":0.000003,"wof:name":"Null Island","wof:placetype":"country","name:ita_x_preferred":["Null island"],"wof:hierarchy":[{"country_id":1}],"lbl:latitude":0.0,"geom:area":0.0,"geom:longitude":0.00001,"wof:id":1,"wof:lastmodified":1496966656,"wof:belongsto":[],"wof:concordances":{"wd:id":"Q16896007","wk:page":"Null_Island"},"wof:repo":"whosonfirst-data","src:geom":"nullisland","wof:country":"XN","geom:area_square_m":3448.94394,"wof:tags":[],"wof:breaches":[],"edtf:inception":"uuuu","iso:country":"XN","geom:bbox":"-0.0005,-0.000282,0.000379,0.000309","name:spa_x_preferred":["Null Island"],"name:eng_x_preferred":["Null Island"],"wof:superseded_by":[],"wof:supersedes":[85681319],"lbl:longitude":0.0,"name:fra_x_preferred":["Null Island"],"wof:geomhash":"e9049476e168a570accab5e984de9c6a","wof:parent_id":0,"mz:hierarchy_label":1,"edtf:cessation":"uuuu"},"geometry":{"type":"MultiPolygon","coordinates":[[[[-4.78E-4,1.6E-5],[-4.64E-4,1.8E-5],...
```

So far so good, except for this part:

```
"coordinates":[[[[-4.78E-4,1.6E-5],[-4.64E-4,1.8E-5],...
```

Please tell me there's an option to prevent scientific notation, Java. See also:

* https://github.com/aaronland/java-whosonfirst-geojson/blob/master/src/main/java/org/whosonfirst/geojson/HelloWorld.java#L52-L72
* https://stackoverflow.com/questions/11586299/how-to-prevent-gson-from-converting-a-long-number-a-json-string-to-scientific/23483692
* https://stackoverflow.com/questions/11119094/switch-off-scientific-notation-in-gson-double-serialization

## See also

* https://github.com/bjornharrtell/jts2geojson
* https://github.com/filosganga/geogson
* https://github.com/google/gson