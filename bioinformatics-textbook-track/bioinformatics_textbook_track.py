def compute_the_hamming_distance_between_two_strings(dna_string_1, dna_string_2):
    hamming_distance = 0
    for i in range(len(dna_string_1)):
        if dna_string_1[i] != dna_string_2[i]:
            hamming_distance += 1
    return hamming_distance
