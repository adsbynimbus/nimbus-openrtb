package requestutil

import "github.com/marcsantiago/govalidator"

// IsRequestValid will validate the structure
// result will be equal to `false` if there are any errors
// the error will contain a small description about the failure
func IsRequestValid(requestStructure interface{}) (bool, error) {
	return govalidator.ValidateStruct(requestStructure)
}
