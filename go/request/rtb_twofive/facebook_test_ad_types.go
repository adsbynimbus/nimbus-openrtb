package twofive

type FacebookTestAdType string

// below are constants that can used to change the ad demo type in the Facebook response
// for more information on the details of each demo type and requirements see the Facebook documentation in the below link
// https://developers.facebook.com/docs/audience-network/overview/in-house-mediation/server-to-server/testing
const (
	VideoLandscapeAppInstall46Seconds FacebookTestAdType = "VID_HD_16_9_46S_APP_INSTALL"
	VideoLandscapeLink46Seconds                          = "VID_HD_16_9_46S_LINK"
	VideoLandscapeAppInstall15Seconds                    = "VID_HD_16_9_15S_APP_INSTALL"
	VideoLandscapeLink15Seconds                          = "VID_HD_16_9_15S_LINK"
	VideoPortraitAppInstall39Seconds                     = "VID_HD_9_16_39S_APP_INSTALL"
	VideoPortraitLink39Seconds                           = "VID_HD_9_16_39S_LINK"
	ImageLandscapeAppInstall                             = "IMG_16_9_APP_INSTALL"
	ImageLandscapeLink                                   = "IMG_16_9_LINK"
	CarouselImageAppInstall                              = "CAROUSEL_IMG_SQUARE_APP_INSTALL"
	CarouselImageLink                                    = "CAROUSEL_IMG_SQUARE_LINK"
)
