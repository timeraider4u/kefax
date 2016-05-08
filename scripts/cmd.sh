#HELL="HelloC.c"
HELL="iosf_mbi.c"
GCC1="${HELL}.output"
GCC2="${HELL}.output.2"

CDT1="${HELL}.i"
CDT2="${HELL}.i.2"

#gcc -E ${HELL} > ${GCC1}
cp ${GCC1} ${GCC2}
cp ${CDT1} ${CDT2}

sed '/^#/d' -i ${GCC2}
sed '/^$/d' -i ${GCC2}
sed '/^$/d' -i ${CDT2}
#sed '/^\w+$/d' -i ${GCC2}
#sed '/^\w+$/d' -i ${CDT2}

gcc -dM -E - < /dev/null > predefined_macros.dat

diff ${GCC2} ${CDT2} --ignore-all-space

diff -Naur ${GCC2} ${CDT2} --ignore-all-space > MyDiff.patch
