def compute_the_hamming_distance_between_two_strings(dna_string_1, dna_string_2):
    hamming_distance = 0
    for i in range(len(dna_string_1)):
        if dna_string_1[i] != dna_string_2[i]:
            hamming_distance += 1
    return hamming_distance


def find_the_reverse_complement_of_a_string(dna_string):
    reverse_complement_dna_string = ""
    for char in dna_string:
        if char == 'A':
            reverse_complement_dna_string = 'T' + reverse_complement_dna_string
        elif char == 'T':
            reverse_complement_dna_string = 'A' + reverse_complement_dna_string
        elif char == 'G':
            reverse_complement_dna_string = 'C' + reverse_complement_dna_string
        elif char == 'C':
            reverse_complement_dna_string = 'G' + reverse_complement_dna_string
    return reverse_complement_dna_string
