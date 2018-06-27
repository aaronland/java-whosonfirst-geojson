package org.whosonfirst.geojson;

// https://commons.apache.org/proper/commons-cli/usage.html

import org.apache.commons.cli.*;
// import java.lang.reflect.Type;
// import java.math.BigDecimal;
import java.nio.file.*;
import java.nio.charset.*;

// import org.wololo.geojson.*;
// Feature feature = (Feature) GeoJSONFactory.create(json);

import com.google.gson.*;
import com.github.filosganga.geogson.gson.*;
import com.github.filosganga.geogson.model.*;

public class HelloWorld {
    
    public static void main(String[] args) {

	Options options = new Options();

	// this ensures that -h works
	options.addOption(OptionBuilder.withLongOpt("help").create('h'));

	// this does not...
	// Option help = new Option("h", "help", true, "show usage");
	// options.addOption(help);
	
	CommandLineParser parser = new DefaultParser();
	CommandLine cmd = null;

	try {
	    cmd = parser.parse(options, args);	    
	} catch( ParseException exp ) {
	    System.out.println( "Unexpected exception:" + exp.getMessage() );
	    System.exit(1); 
	}
	
	if ((cmd.hasOption("h")) || (args.length == 0)){

	    String app_name = "hello world";
		
	    HelpFormatter formatter = new HelpFormatter();
	    formatter.printHelp(app_name, options );

	    System.exit(0); 
	    return;
	}

	GsonBuilder builder = new GsonBuilder();
	builder.registerTypeAdapterFactory(new GeometryAdapterFactory());

	// this doesn't seem to do anything... (20180627/thisisaaronland)
	// https://stackoverflow.com/questions/11119094/switch-off-scientific-notation-in-gson-double-serialization

	/*
	builder.registerTypeAdapter(Double.class,  new JsonSerializer<Double>() {
	    
	    @Override
	    public JsonElement serialize(final Double src, final Type typeOfSrc, final JsonSerializationContext context) {
		BigDecimal value = BigDecimal.valueOf(src);
		
		return new JsonPrimitive(value);
	    }
	});
	*/

	// Neither does this... (20180627/thisisaaronland)
	// https://stackoverflow.com/questions/11586299/how-to-prevent-gson-from-converting-a-long-number-a-json-string-to-scientific/23483692
	// builder.setLongSerializationPolicy( LongSerializationPolicy.STRING );
		
	Gson gson = builder.create();
	
	for (String path : args){

	    Path p = Paths.get(path);
	    System.out.println(p);

	    String json = null;
		
	    try {
		byte[] b = Files.readAllBytes(p);
		json = new String(b, StandardCharsets.UTF_8);
	    } catch (Exception exp){
		System.out.println( "Unexpected exception:" + exp.getMessage() );
		System.exit(1); 	    
	    }

	    Feature feature = gson.fromJson(json, Feature.class);	   
	    
	    System.out.println(feature);
	    System.out.println(gson.toJson(feature));
	}
    }
    
}
