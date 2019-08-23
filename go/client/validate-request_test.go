package client

import "testing"

func TestIsRequestValid(t *testing.T) {
	type foo struct {
		Bar  string  `valid:"in(bar|nimbus),required"`
		Ping int     `valid:"range(0|10),required"`
		Pong float64 `valid:"required"`
	}

	type args struct {
		requestStructure interface{}
	}
	tests := []struct {
		name    string
		args    args
		want    bool
		wantErr bool
	}{
		{
			name: "structure should be valid",
			args: args{
				requestStructure: foo{
					Bar:  "nimbus",
					Ping: 10,
					Pong: 1.00,
				},
			},
			want:    true,
			wantErr: false,
		},
		{
			name: "structure should be invalid, bar does not validate",
			args: args{
				requestStructure: foo{
					Bar:  "foo",
					Ping: 10,
					Pong: 1.00,
				},
			},
			want:    false,
			wantErr: true,
		},
		{
			name: "structure should be invalid, ping is to high",
			args: args{
				requestStructure: foo{
					Bar:  "bar",
					Ping: 20,
					Pong: 1.00,
				},
			},
			want:    false,
			wantErr: true,
		},
		{
			name: "structure should be invalid, ping is missing",
			args: args{
				requestStructure: foo{
					Bar:  "bar",
					Ping: 5,
				},
			},
			want:    false,
			wantErr: true,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got, err := IsRequestValid(tt.args.requestStructure)
			if (err != nil) != tt.wantErr {
				t.Errorf("IsRequestValid() error = %v, wantErr %v", err, tt.wantErr)
				return
			}
			if got != tt.want {
				t.Errorf("IsRequestValid() = %v, want %v", got, tt.want)
			}
		})
	}
}
