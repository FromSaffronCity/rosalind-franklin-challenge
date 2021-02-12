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


def find_all_occurrences_of_a_pattern_in_a_string(pattern, genome):
    starting_positions = []
    next_starting_position = 0

    while next_starting_position != -1 and next_starting_position < len(genome):
        next_starting_position = genome.find(pattern, next_starting_position)
        if next_starting_position != -1:
            starting_positions.append(next_starting_position)
            next_starting_position += 1
    return starting_positions


def compute_the_number_of_times_a_pattern_appears_in_a_text(dna_string, pattern):
    pattern_count = next_starting_position = 0
    while next_starting_position != -1 and next_starting_position < len(dna_string):
        next_starting_position = dna_string.find(pattern, next_starting_position)
        if next_starting_position != -1:
            pattern_count += 1
            next_starting_position += 1
    return pattern_count


def implement_number_to_pattern(index, k):
    nucleotide_bases = ['A', 'C', 'G', 'T']
    dna_string_pattern = ""
    for i in range(k):
        dna_string_pattern = nucleotide_bases[index%4] + dna_string_pattern
        index //=4
    return dna_string_pattern


def implement_pattern_to_number(dna_string_pattern):
    dna_string_pattern = dna_string_pattern[::-1]
    number = 0
    for index in range(len(dna_string_pattern)):
        if dna_string_pattern[index] == 'A':
            number += (4**index)*0
        elif dna_string_pattern[index] == 'C':
            number += (4**index)*1
        elif dna_string_pattern[index] == 'G':
            number += (4**index)*2
        elif dna_string_pattern[index] == 'T':
            number += (4**index)*3
    return number
