Question 5_1



Job 1 : 
Word Frequency in Doc

	map :

		input (document, each line contents)

		output (word@document, 1)

	reducer :

		n = sum of the values of for each key "word@document"

		output (word@document, n)



Job 2 :
Word Counts for Docs

	map :

		input (word@document, n)

		Re-arrange the mapper to have the key based on each document

		output (document, word=n)

	reducer :

		N = totalWordsInDoc = sum(word=n) for each document

		output (word@document, n/N)



Job 3 : 
TFIDF

	map :

		Input (word@document, n/N)

		Re-arrange the mapper to have the word as the key, since we need to count the number of documents where it occurs

		output (term, document=n/N)


	reducer :

		D = total number of documents in corpus. This can be passed by the driver as a constant

		d = number of documents in corpus where the term appears. It is a countuer over the reduced values for each term

		TFIDF = n/N * log(D/d)
		output (word@document, d/D, n/N, TFIDF)
