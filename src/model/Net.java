package model;

import java.io.FileInputStream;

import model.ArraySizeMismatchException;

public class Net {

	String[] patterns;
	double[] weights;
	int[] matchCount;

	public Net(String[] patterns) {
		this.patterns = patterns;
		this.weights = new double[patterns.length];
		this.matchCount = new int[patterns.length];

		// Initializes weights[]
		for (int i = 0; i < patterns.length; i++) {
			weights[i] = patterns[i].length();
		}

	}

	public Net() {
		this.patterns = new String[] { "df", "fp", "kj", "l;", ";", "'", "sd", "fg", "hj", "gj", "[", "]", "/", "fd",
				"gm", "sg", "ad", "hf", "uj", "jf", "fg", "cvb", ",.", "kjh" };
		this.weights = new double[patterns.length];
		this.matchCount = new int[patterns.length];

		// Initializes weights[]
		for (int i = 0; i < patterns.length; i++) {
			weights[i] = patterns[i].length();
		}

	}

	public Net(String file) {
		try {
			NetTrainer trainer = new NetTrainer(new FileInputStream(file));
			trainer.train();
			this.patterns = trainer.getPatterns();
			this.weights = trainer.getWeights();
			this.matchCount = new int[patterns.length];
		}

		catch (Exception e) {

		}

	}

	public Net(String[] patterns, double[] weights) throws ArraySizeMismatchException {
		this.patterns = patterns;
		this.weights = weights;
		this.matchCount = new int[patterns.length];

		if (patterns.length != weights.length)
			throw new ArraySizeMismatchException();

	}

	public double check(String sample) {

		sample = sample.toLowerCase();
		double mashProbability = 0;
		int stringLength = sample.length();
		int patternCountAccumulator = 0;

		// populates patternCount[]
		for (int i = 0; i < patterns.length; i++) {
			matchCount[i] = countOccurrences(patterns[i], sample);
			patternCountAccumulator += (matchCount[i] * weights[i]);
		}

		mashProbability = (double) patternCountAccumulator / (double) stringLength;
		System.out.println(mashProbability);
		return mashProbability;
	}

	private int countOccurrences(String pattern, String sample) {
		int index = sample.indexOf(pattern);
		int count = 0;
		while (index != -1) {
			count++;
			sample = sample.substring(index + 1);
			index = sample.indexOf(pattern);
		}
		return count;
	}

}
