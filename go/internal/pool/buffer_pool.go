package pool

// Warning do not use if passing []byte around, race conditions can occur
import (
	"bytes"
	"sync"
)

// bytesBuffer creates a Bytes.Buffer pool that can be used to stop object churn
var bytesBuffer = sync.Pool{
	// New is called when a new instance is needed
	New: func() interface{} {
		return new(bytes.Buffer)
	},
}

// GetBuffer fetches a buffer from the pool
func GetBuffer() *bytes.Buffer {
	return bytesBuffer.Get().(*bytes.Buffer)
}

// PutBuffer returns a buffer to the pool, never call this with defer in loops
func PutBuffer(buf *bytes.Buffer) {
	buf.Reset()
	bytesBuffer.Put(buf)
}
