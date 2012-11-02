DESCRIPTION = "Wine - compatibility layer capable of running Windows applications"

SRC_URI = "http://prdownloads.sourceforge.net/wine/wine-${PV}.tar.bz2"
SRC_URI[md5sum] = "0c28702ed478df7a1c097f3a9c4cabd6"
SRC_URI[sha256sum] = "3c233e3811e42c2f3623413783dbcd0f2288014b5645211f669ffd0ba6ae1856"

DEPENDS = "m4 libtool freetype virtual/xserver"

inherit autotools

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=6ab17b41640564434dda85c06b7124f7"

#PARALLEL_MAKE=""

CONFIGURE_OPTIONS = "--without-gettextpo \
                    --without-freetype \
                    --without-v4l \
                    --without-xml \
                    --without-coreaudio \
                    --without-dbus \
                    --without-gphoto \
                    --without-ldap \
                    --without-sane \
                    --without-capi \
                    --without-xslt \
                   "

do_configure() {
	LD_LIBRARY_PATH="${STAGING_LIBDIR}" ./configure --prefix=${prefix} ${CONFIGURE_OPTIONS}
}


do_build() {
	LD_LIBRARY_PATH="${STAGING_LIBDIR}" oe_runmake
}
