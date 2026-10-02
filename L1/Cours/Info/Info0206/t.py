# Generate updated one-page CV with corrected address



from reportlab.platypus import SimpleDocTemplate, Paragraph, Spacer, HRFlowable

from reportlab.lib.styles import getSampleStyleSheet

from reportlab.lib import colors

from reportlab.lib.pagesizes import A4



file_path = "./CV_NidalDahbi"

doc = SimpleDocTemplate(

    file_path,

    pagesize=A4,

    rightMargin=36,

    leftMargin=36,

    topMargin=36,

    bottomMargin=36

)



elements = []

styles = getSampleStyleSheet()



# Compact styles

name_style = styles["Heading1"]

section_style = styles["Heading2"]

normal_style = styles["BodyText"]



name_style.fontSize = 20

section_style.fontSize = 16

normal_style.fontSize = 14

normal_style.leading = 16



# Name

elements.append(Paragraph("Nidal Dahbi", name_style))

elements.append(Spacer(1, 6))



# Updated Contact

contact_text = "n.dahbi25000@gmail.com | " \
"+33 6 24 24 74 90 | " \
"31d rue des Justices, 25000 Besançon"

elements.append(Paragraph(contact_text, normal_style))

elements.append(Spacer(1, 10))



# Profil

elements.append(Paragraph("Profil", section_style))

elements.append(HRFlowable(width="100%", thickness=0.5, color=colors.black))

elements.append(Spacer(1, 4))



profile_text = """

Étudiant en informatique motivé et rigoureux, intéressé par les nouvelles technologies et la cybersécurité.

Esprit d’équipe, adaptabilité et sens des responsabilités.

"""

elements.append(Paragraph(profile_text, normal_style))

elements.append(Spacer(1, 8))



# Formation

elements.append(Paragraph("Formation", section_style))

elements.append(HRFlowable(width="100%", thickness=0.5, color=colors.black))

elements.append(Spacer(1, 4))



education_text = """

2025–2026 : Licence Informatique (Cursus Master en Ingénierie), Université de Reims Champagne-Ardenne<br/>

2025 : Baccalauréat général – Mathématiques, Physique-Chimie (Mathématiques expertes, Euro Allemand)

"""

elements.append(Paragraph(education_text, normal_style))

elements.append(Spacer(1, 8))



# Expériences

elements.append(Paragraph("Expériences et projets", section_style))

elements.append(HRFlowable(width="100%", thickness=0.5, color=colors.black))

elements.append(Spacer(1, 4))



experience_text = """

2023 : Projet Puissance 4 en ligne – Architecture client-serveur (sockets TCP).<br/>

2021 : Stage au service informatique de l’INSPE de Besançon – Mise en service de postes.<br/>

Stage en restauration – McDilan, Saint-Vit : Poste en plonge, travail en équipe et respect des normes d’hygiène.

"""

elements.append(Paragraph(experience_text, normal_style))

elements.append(Spacer(1, 8))



# Distinctions

elements.append(Paragraph("Distinctions", section_style))

elements.append(HRFlowable(width="100%", thickness=0.5, color=colors.black))

elements.append(Spacer(1, 4))



achievements_text = """

2025 : 1re place lycéen – Passe ton hack d’abord<br/>

2024 : 2e place – Cybersecurity Awareness Week (Red Team)

"""

elements.append(Paragraph(achievements_text, normal_style))

elements.append(Spacer(1, 8))



# Compétences

elements.append(Paragraph("Compétences", section_style))

elements.append(HRFlowable(width="100%", thickness=0.5, color=colors.black))

elements.append(Spacer(1, 4))



skills_text = "Langages : C, Java, Python | Travail d’équipe | Adaptabilité"

elements.append(Paragraph(skills_text, normal_style))

elements.append(Spacer(1, 8))



# Centres d’intérêt

elements.append(Paragraph("Centres d’intérêt", section_style))

elements.append(HRFlowable(width="100%", thickness=0.5, color=colors.black))

elements.append(Spacer(1, 4))



interests_text = "Cybersécurité, nouvelles technologies, sport (football, musculation)."

elements.append(Paragraph(interests_text, normal_style))



doc.build(elements)



file_path