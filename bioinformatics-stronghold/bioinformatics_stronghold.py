def counting_dna_nucleotides(dna_string):
    count = [0, 0, 0, 0]

    for char in dna_string:
        if char == 'A':
            count[0] += 1
        elif char == 'C':
            count[1] += 1
        elif char == 'G':
            count[2] += 1
        elif char == 'T':
            count[3] += 1
    return count


def transcribing_dna_into_rna(dna_string):
    rna_string = ""

    for char in dna_string:
        if char == 'T':
            rna_string += "U"
        else:
            rna_string += char
    return rna_string


def complementing_dna_strand(dna_string):
    complement_strand = ""
    for char in dna_string:
        if char == 'A':
            complement_strand = "T" + complement_strand
        if char == 'T':
            complement_strand = "A" + complement_strand
        if char == 'G':
            complement_strand = "C" + complement_strand
        if char == 'C':
            complement_strand = "G" + complement_strand
    return complement_strand


def rabbits_and_recurrence_relations(month, offspring):
    rabbit_count_1 = rabbit_count_2 = 1

    for i in range(month-2):
        temp = rabbit_count_2 + offspring*rabbit_count_1  # recurrence relation
        rabbit_count_1 = rabbit_count_2
        rabbit_count_2 = temp
    return rabbit_count_2


def counting_point_mutations(dna_string_1, dna_string_2):
    hamming_distance = 0

    for i in range(len(dna_string_1)):
        if dna_string_1[i] != dna_string_2[i]:
            hamming_distance += 1
    return hamming_distance


def finding_motif_in_dna(dna_string, dna_substring):
    locations = []

    for i in range(len(dna_string)-len(dna_substring)+1):
        if dna_string[i:i+len(dna_substring)] == dna_substring:
            locations.append(i+1)
    return locations
