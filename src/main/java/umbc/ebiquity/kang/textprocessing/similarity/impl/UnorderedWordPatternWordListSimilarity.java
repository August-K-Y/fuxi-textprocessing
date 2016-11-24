package umbc.ebiquity.kang.textprocessing.similarity.impl;

import java.util.List;

import umbc.ebiquity.kang.textprocessing.similarity.IWordListSimilarity;

public class UnorderedWordPatternWordListSimilarity implements IWordListSimilarity {

	@Override
	public double computeSimilarity(List<String> wordList1, List<String> wordList2) {
		if(wordList1.size() == 0 || wordList2.size() == 0){
			return 0.0;
		} 
		int wordListSize1 = wordList1.size();
		int wordListSize2 = wordList2.size();
		int matchedWordCount = 0;
		for (int i = 0; i < wordListSize2; i++) {
			if (wordList1.contains(wordList2.get(i))) {
				matchedWordCount++;
			}
		}
		double relationMatchScore = (double) matchedWordCount / ((double) wordListSize1 + (double) wordListSize2 - (double) matchedWordCount);
		return relationMatchScore;
	}

}
