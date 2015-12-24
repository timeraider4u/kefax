package at.jku.weiner.c.preprocess.utils.macros;

enum MatchState {
	Normal, InString, InChar, BackslashInString, BackslashInChar
}
