HELL="client"
GCC1="${HELL}.output"
GCC2="${HELL}.output.2"

CDT1="${HELL}.i"
CDT2="${HELL}.i.2"

#gcc -E ${HELL} > ${GCC1}
cd ..
gcc -Wp,-MD,drivers/gpu/drm/nouveau/core/core/.client.o.d  -nostdinc -isystem /usr/lib/gcc/x86_64-pc-linux-gnu/4.8.4/include -I./arch/x86/include -Iarch/x86/include/generated  -Iinclude -I./arch/x86/include/uapi -Iarch/x86/include/generated/uapi -I./include/uapi -Iinclude/generated/uapi -include ./include/linux/kconfig.h -D__KERNEL__ -Wall -Wundef -Wstrict-prototypes -Wno-trigraphs -fno-strict-aliasing -fno-common -Werror-implicit-function-declaration -Wno-format-security -std=gnu89 -m64 -mno-80387 -mno-fp-ret-in-387 -mtune=generic -mno-red-zone -mcmodel=kernel -funit-at-a-time -maccumulate-outgoing-args -DCONFIG_AS_CFI=1 -DCONFIG_AS_CFI_SIGNAL_FRAME=1 -DCONFIG_AS_CFI_SECTIONS=1 -DCONFIG_AS_FXSAVEQ=1 -DCONFIG_AS_CRC32=1 -DCONFIG_AS_AVX=1 -DCONFIG_AS_AVX2=1 -pipe -Wno-sign-compare -fno-asynchronous-unwind-tables -mno-sse -mno-mmx -mno-sse2 -mno-3dnow -mno-avx -fno-delete-null-pointer-checks -O2 --param=allow-store-data-races=0 -Wframe-larger-than=2048 -fstack-protector -Wno-unused-but-set-variable -fno-omit-frame-pointer -fno-optimize-sibling-calls -fno-var-tracking-assignments -Wdeclaration-after-statement -Wno-pointer-sign -fno-strict-overflow -fconserve-stack -Werror=implicit-int -Werror=strict-prototypes -Iinclude/drm -Idrivers/gpu/drm/nouveau/core/include -Idrivers/gpu/drm/nouveau/core -Idrivers/gpu/drm/nouveau  -DMODULE  -D"KBUILD_STR(s)=\#s" -D"KBUILD_BASENAME=KBUILD_STR(client)"  -D"KBUILD_MODNAME=KBUILD_STR(nouveau)" -c -E drivers/gpu/drm/nouveau/core/core/client.c \
 > compare/${GCC1}

cd compare
cp ${GCC1} ${GCC2}
cp ${CDT1} ${CDT2}

sed '/^#/d' -i ${GCC2}
sed '/^$/d' -i ${GCC2}
sed '/^$/d' -i ${CDT2}
#sed '/^\w+$/d' -i ${GCC2}
#sed '/^\w+$/d' -i ${CDT2}

gcc -dM -E - < /dev/null > predefined_macros.dat

diff ${GCC2} ${CDT2} --ignore-all-space --ignore-blank-lines | less

diff -Naur ${GCC2} ${CDT2} --ignore-all-space --ignore-blank-lines > MyDiff.patch
