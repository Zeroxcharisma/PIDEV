<?php

namespace App\Entity;

use App\Repository\TestfitnessRepository;
use Doctrine\ORM\Mapping as ORM;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * @ORM\Entity(repositoryClass=TestfitnessRepository::class)
 */
class Testfitness
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="integer")
     * @Assert\NotBlank(message="Preciser la duree du Test")
     */
    private $duree;

    /**
     * @ORM\Column(type="date")
     * @Assert\NotBlank(message="Preciser la date du Test")
     */
    private $dateTest;

    /**
     * @ORM\ManyToOne(targetEntity=Cours::class)
     * @ORM\JoinColumn(onDelete="CASCADE")
     */
    private $cours;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getDuree(): ?int
    {
        return $this->duree;
    }

    public function setDuree(int $duree): self
    {
        $this->duree = $duree;

        return $this;
    }

    public function getDateTest(): ?\DateTimeInterface
    {
        return $this->dateTest;
    }

    public function setDateTest(\DateTimeInterface $dateTest): self
    {
        $this->dateTest = $dateTest;

        return $this;
    }

    public function getCours(): ?cours
    {
        return $this->cours;
    }

    public function setCours(?cours $cours): self
    {
        $this->cours = $cours;

        return $this;
    }
}
