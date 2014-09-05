package com.entopix.maui;

import com.entopix.maui.main.MauiModelBuilder;
import com.entopix.maui.main.MauiTopicExtractor;

/**
 * StandaloneMain - allows us to run the train or test options in the single standalone.
 *
 * Passes on all but the first option.
 *
 * @author Richard Vowles - https://google.com/+RichardVowles
 */
public class StandaloneMain {
	public static void main(String[] args) {
		if (args.length == 0 || (!args[0].equalsIgnoreCase("train") && !args[0].equalsIgnoreCase("test"))) {
			System.out.printf("Maui Standalone Runner\njava -jar standalone.jar [train|test] options...\nPlease specify train or test and then the appropriate parameters.\n");

			System.exit(-1);
		}

		boolean train = args[0].equalsIgnoreCase("train");

		String[] remainingArgs = new String[args.length - 1];

		System.arraycopy(args, 1, remainingArgs, 0, args.length-1);

		if (train) {
			MauiModelBuilder.main(remainingArgs);
		} else {
			MauiTopicExtractor.main(remainingArgs);
		}
	}
}
