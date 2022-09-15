package main

import (
	"fmt"
	"math"
	"math/rand"
	"time"
)

type Monk struct {
	index  int
	energy int
}

func recursiveCall(monks []Monk, resultChan chan Monk) {
	size := len(monks)

	if size == 1 {
		resultChan <- monks[0]
		return
	}

	var leftResult Monk
	var rightResult Monk
	leftResultChan := make(chan Monk, 1)
	rightResultChan := make(chan Monk, 1)
	go recursiveCall(monks[0:size/2], leftResultChan)
	go recursiveCall(monks[size/2:size], rightResultChan)
	leftResult = <-leftResultChan
	rightResult = <-rightResultChan

	result := Monk{}
	if leftResult.energy >= rightResult.energy {
		result.index = leftResult.index
		result.energy = leftResult.energy - rightResult.energy
	} else {
		result.index = rightResult.index
		result.energy = rightResult.energy - leftResult.energy
	}
	time.Sleep(1 * time.Second)
	resultChan <- result
	close(resultChan)
}

func start(energy []int) Monk {
	size := len(energy)
	if math.Ceil(math.Log2(float64(size))) != math.Floor(math.Log2(float64(size))) {
		fmt.Println("Error. n must be a power of 2.")
		return Monk{-1, -1}
	}

	var monks []Monk
	for i, e := range energy {
		monks = append(monks, Monk{i, e})
	}

	resultChan := make(chan Monk, 1)
	go recursiveCall(monks, resultChan)
	return <-resultChan
}

func main() {
	const min = 10
	const max = 100
	const n = 16
	var inputEnergy []int

	rand.Seed(time.Now().Unix())
	for i := 1; i <= n; i++ {
		randN := min + rand.Intn(max-min+1)
		inputEnergy = append(inputEnergy, randN)
	}
	fmt.Println("\nInput:\n ", inputEnergy)

	result := start(inputEnergy)
	fmt.Println("\nResult:")
	fmt.Println(" Index: ", result.index, "\n Remaining energy: ", result.energy)
}
