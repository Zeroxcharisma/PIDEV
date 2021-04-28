<?php

namespace App\Entity;

use App\Repository\EvenementRepository;
use Doctrine\ORM\Mapping as ORM;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * @ORM\Entity(repositoryClass=EvenementRepository::class)
 */
class Evenement
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotBlank(message="merci de donner un lieu a l'evenement")
     */
    private $lieu;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotBlank(message="merci de donner un type a l'evenement")
     *
     */
    private $type;

    /**
     * @ORM\Column(type="text")
     * @Assert\NotBlank(message="merci de donner une description a l'evenement")
     */
    private $description;

    /**
     * @ORM\Column(type="date")
     *
     */
    private $date;

    /**
     * @ORM\OneToMany(targetEntity=Participant::class, mappedBy="evenement")
     */
    private $participants;

    /**
     * @ORM\OneToMany(targetEntity=Evenementlike::class, mappedBy="evenement", orphanRemoval=true)
     */
    private $evenementlikes;

    public function __construct()
    {
        $this->participants = new ArrayCollection();
        $this->evenementlikes = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getLieu(): ?string
    {
        return $this->lieu;
    }

    public function setLieu(string $lieu): self
    {
        $this->lieu = $lieu;

        return $this;
    }

    public function getType(): ?string
    {
        return $this->type;
    }

    public function setType(string $type): self
    {
        $this->type = $type;

        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(string $description): self
    {
        $this->description = $description;

        return $this;
    }

    public function getDate(): ?\DateTimeInterface
    {
        return $this->date;
    }

    public function setDate(\DateTimeInterface $date): self
    {
        $this->date = $date;

        return $this;
    }

    /**
     * @return Collection|Participant[]
     */
    public function getParticipants(): Collection
    {
        return $this->participants;
    }

    public function addParticipant(Participant $participant): self
    {
        if (!$this->participants->contains($participant)) {
            $this->participants[] = $participant;
            $participant->setEvenement($this);
        }

        return $this;
    }

    public function removeParticipant(Participant $participant): self
    {
        if ($this->participants->removeElement($participant)) {
            // set the owning side to null (unless already changed)
            if ($participant->getEvenement() === $this) {
                $participant->setEvenement(null);
            }
        }

        return $this;
    }

    /**
     * @return Collection|Evenementlike[]
     */
    public function getEvenementlikes(): Collection
    {
        return $this->evenementlikes;
    }

    public function addEvenementlike(Evenementlike $evenementlike): self
    {
        if (!$this->evenementlikes->contains($evenementlike)) {
            $this->evenementlikes[] = $evenementlike;
            $evenementlike->setEvenement($this);
        }

        return $this;
    }

    public function removeEvenementlike(Evenementlike $evenementlike): self
    {
        if ($this->evenementlikes->removeElement($evenementlike)) {
            // set the owning side to null (unless already changed)
            if ($evenementlike->getEvenement() === $this) {
                $evenementlike->setEvenement(null);
            }
        }

        return $this;
    }

    /**
     *
     * @return bool
     */
    public function isLiked() : bool  {
        foreach ($this->likes as $like){
             return true;

        }
        return false;
    }
}
